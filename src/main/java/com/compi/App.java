package com.compi;

import picocli.CommandLine;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java_cup.runtime.Symbol;

@CommandLine.Command(name = "compi", mixinStandardHelpOptions = true, version = "0.0.1",
        description = "Simple lexer and parser for C-like language.")
public class App implements Callable<Integer> {

    @CommandLine.Option(names = {"-f", "--file"}, description = "File to read", required = false)
    private File file;

    @Override
    public Integer call() throws Exception {
        if (file != null) {
            // Lee el archivo de entrada
            BufferedReader bfr = Files.newBufferedReader(file.toPath());
            DemoLexer lexer = new DemoLexer(bfr);
            Symbol token = lexer.next_token();
            while (token.sym != sym.EOF) {
                System.out.println("Token: " + token.sym + " Lexema: " + token.value);
                token = lexer.next_token();
            }

            // Iniciar el parser con el lexer
            Parser parser = new Parser(lexer);

            try {
                // Ejecutar el parser
                parser.parse();
                System.out.println("Análisis léxico y sintáctico completado.");
            } catch (Exception e) {
                System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
            }

        } else {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!input.equals("exit")) {
                System.out.print("Por favor ingrese la cadena > ");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }

                DemoLexer demoLexer = new DemoLexer(new StringReader(input));

                // Iniciar el parser con el lexer
                Parser parser = new Parser(demoLexer);

                try {
                    // Ejecutar el parser
                    parser.parse();
                    System.out.println("Análisis léxico y sintáctico completado.");
                } catch (Exception e) {
                    System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
