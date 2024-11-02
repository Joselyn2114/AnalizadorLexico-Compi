package com.compi;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.List;
import java_cup.runtime.Symbol;

public class App {

    public static void main(String[] args) {
        try {
            File file = new File("demo.txt");  // Archivo de prueba
            BufferedReader bfr = Files.newBufferedReader(file.toPath());
            DemoLexer lexer = new DemoLexer(bfr);

            // Tokenización y análisis léxico
            Symbol token = lexer.yylex();
            while (token.sym != sym.EOF) {
                System.out.println("Token: " + token.sym + " Lexema: " + token.value);
                token = lexer.yylex();
            }

            // Imprimir errores léxicos (si los hay)
            if (!lexer.getLexicalErrors().isEmpty()) {
                System.out.println("Errores léxicos encontrados:");
                for (String error : lexer.getLexicalErrors()) {
                    System.out.println(error);
                }
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
