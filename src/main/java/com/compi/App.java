/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compi;

import java_cup.runtime.Symbol;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import jflex.generator.LexGenerator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class App {
    public static void main(String[] args) {
        try {
            String ruta1 = "C:\\Users\\Jhonn\\Documents\\GitHub\\AnalizadorLexico-Compi\\src\\main\\java\\com\\compi\\simple.flex";
            String ruta2 = "C:\\Users\\Jhonn\\Documents\\GitHub\\AnalizadorLexico-Compi\\src\\main\\java\\com\\compi\\LexerCup.flex";
            String[] rutaS = {"-parser", "Sintax", "C:\\Users\\Jhonn\\Documents\\GitHub\\AnalizadorLexico-Compi\\src\\main\\java\\com\\compi\\Sintax.cup"};

            generar(ruta1, ruta2, rutaS);

            // Procesar un archivo de entrada y mostrar resultados
            File archivoEntrada = new File("C:\\Users\\Jhonn\\Documents\\GitHub\\AnalizadorLexico-Compi\\demo.txt");
            LexerCup lexer = new LexerCup(new FileReader(archivoEntrada));
            Symbol token;
            while ((token = lexer.next_token()).sym != sym.EOF) {
                System.out.println("Token: " + token);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo = new File(ruta1);
        new LexGenerator(archivo).generate();  // Utilizando LexGenerator
        archivo = new File(ruta2);
        new LexGenerator(archivo).generate();
        java_cup.Main.main(rutaS);
    }
}

