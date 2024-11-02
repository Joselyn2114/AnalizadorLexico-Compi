package com.compi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java_cup.runtime.Symbol;

public class App {

    public static void main(String[] args) {
        File file = null;

        // Comprobamos si hay un archivo pasado como argumento
        if (args.length > 0) {
            file = new File(args[0]); // Primer argumento como archivo
        } else {
            // Si no se pasa archivo, intenta leer "demo.txt" desde la raíz del proyecto
            file = new File("demo.txt");
        }

        if (file.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
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

            } catch (Exception e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.err.println("Archivo no encontrado: " + file.getPath());
        }
    }
}
