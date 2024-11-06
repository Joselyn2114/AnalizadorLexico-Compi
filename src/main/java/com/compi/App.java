package com.compi;

import TokenTable.TokenTable;
import scanner.tokens.TokenType;
import java_cup.runtime.Symbol;
import picocli.CommandLine;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.Scanner;

@CommandLine.Command(name = "compi", mixinStandardHelpOptions = true, version = "0.0.1",
        description = "Lexer and Parser for a C-like language.")
public class App implements Callable<Integer> {

    @CommandLine.Option(names = {"-f", "--file"}, description = "File to read", required = false)
    private File file;

    @Override
    public Integer call() throws Exception {
        TokenTable validTokens = new TokenTable();
        TokenTable errors = new TokenTable();

        if (file != null) {
            try (FileReader reader = new FileReader(file)) {
                DemoLexer lexer = new DemoLexer(reader);
                Symbol token;

                // Tokenización y registro de tokens o errores
                while ((token = lexer.yylex()).sym != sym.EOF) {
                    int tokenSym = token.sym;
                    String lexeme = (token.value != null) ? token.value.toString() : "null"; // Manejo de null

                    if (tokenSym < 0) { // Manejo de errores léxicos
                        TokenType type = classifyErrorToken(tokenSym);
                        errors.addTokenRecord(tokenSym, lexeme, type.name(), token.left);
                    } else { // Token válido
                        TokenType type = classifyValidToken(tokenSym);
                        validTokens.addTokenRecord(tokenSym, lexeme, type.name(), token.left);
                    }
                }

                // Inicializar el parser con el lexer
                Parser parser = new Parser(lexer);
                try {
                    parser.parse();
                    System.out.println("Análisis léxico y sintáctico completado.");

                    // Mostrar errores sintácticos si los hay
                    if (!parser.getSyntaxErrors().isEmpty()) {
                        System.out.println("Errores sintácticos encontrados:");
                        for (String error : parser.getSyntaxErrors()) {
                            System.out.println(error);
                        }
                    }

                } catch (Exception e) {
                    System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
                }

                // Imprimir tablas de tokens válidos y errores
                System.out.println("Tokens Válidos:");
                validTokens.printTable();
                System.out.println("Errores Léxicos:");
                errors.printTable();

            } catch (Exception e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            // Modo interactivo si no se proporciona un archivo
            interactiveMode();
        }

        return 0;
    }

    private TokenType classifyValidToken(int tokenSym) {
        if (tokenSym < 47) {
            return TokenType.OPERATOR;
        } else if (tokenSym == 47) {
            return TokenType.IDENTIFIER;
        } else if (tokenSym <= 80) {
            return TokenType.KEYWORD;
        } else {
            return TokenType.LITERAL;
        }
    }

    private TokenType classifyErrorToken(int tokenSym) {
        return switch (tokenSym) {
            case -1 -> TokenType.IDENTIFIER;
            case -2 -> TokenType.OPERATOR;
            case -3 -> TokenType.KEYWORD;
            case -4 -> TokenType.LITERAL;
            default -> TokenType.UNKNOWN;
        };
    }

    private void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("exit")) {
            System.out.print("Por favor ingrese la cadena > ");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            DemoLexer lexer = new DemoLexer(new java.io.StringReader(input));
            TokenTable validTokens = new TokenTable();
            TokenTable errors = new TokenTable();

            try {
                Symbol token;

                while ((token = lexer.yylex()).sym != sym.EOF) {
                    int tokenSym = token.sym;
                    String lexeme = (token.value != null) ? token.value.toString() : "null";

                    if (tokenSym < 0) { // Manejo de errores léxicos
                        TokenType type = classifyErrorToken(tokenSym);
                        errors.addTokenRecord(tokenSym, lexeme, type.name(), token.left);
                    } else { // Token válido
                        TokenType type = classifyValidToken(tokenSym);
                        validTokens.addTokenRecord(tokenSym, lexeme, type.name(), token.left);
                    }
                }

                Parser parser = new Parser(lexer);
                parser.parse();

                System.out.println("Tokens Válidos:");
                validTokens.printTable();
                System.out.println("Errores Léxicos:");
                errors.printTable();

                if (!parser.getSyntaxErrors().isEmpty()) {
                    System.out.println("Errores sintácticos encontrados:");
                    for (String error : parser.getSyntaxErrors()) {
                        System.out.println(error);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
