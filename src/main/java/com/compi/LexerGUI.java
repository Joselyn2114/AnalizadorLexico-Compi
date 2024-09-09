package com.compi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analizador Léxico");

        // Crear StyledTextArea para entrada de texto con resaltado de sintaxis
        StyleClassedTextArea inputArea = new StyleClassedTextArea();
        inputArea.setWrapText(true);
        inputArea.setParagraphGraphicFactory(LineNumberFactory.get(inputArea));
        inputArea.setPrefSize(800, 300);  // tamaño  del area de entrada

        Button analyzeButton = new Button("Analizar");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefSize(800, 300);  //  tamaño  del area de salida

        // Resaltar sintaxis mientras se escribe
        inputArea.textProperty().addListener((obs, oldText, newText) -> {
            applyHighlighting(inputArea, newText);
        });

        // Acción del  "Analizar"
        analyzeButton.setOnAction(event -> {
            String inputText = inputArea.getText();
            outputArea.clear(); // Limpiar la salida anterior
            analyzeText(inputText, outputArea);
        });

        // Organizar los componentes en un layout
        VBox vbox = new VBox(10, inputArea, analyzeButton, outputArea);
        vbox.setPrefSize(900, 700);  // Ajusta el tamaño preferido del VBox

        Scene scene = new Scene(vbox, 900, 700);  // Ajusta el tamaño de la escena
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(900);  // Ajusta el tamaño mínimo de la ventana
        primaryStage.setMinHeight(700);
        primaryStage.show();
    }

    // Método para aplicar resaltado de sintaxis
    private void applyHighlighting(StyleClassedTextArea area, String text) {
        area.clearStyle(0, text.length());

        // Expresiones regulares para diferentes tipos de tokens
        Pattern pattern = Pattern.compile("\\b(\\d+\\.?\\d*|\\w+|[-+*/=;])\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String token = matcher.group();
            String styleClass = getStyleClassForToken(token);
            area.setStyleClass(matcher.start(), matcher.end(), styleClass);
        }
    }

    // Método para determinar la clase de estilo CSS basado en el token
    private String getStyleClassForToken(String token) {
        if (token.matches("\\d+\\.?\\d*")) {
            return "number"; // Números
        } else if (token.matches("\\w+")) {
            return "identifier"; // Identificadores
        } else if (token.matches("[-+*/=;]")) {
            return "operator"; // Operadores
        } else {
            return "error"; // Otros como errores
        }
    }

    // Método para ejecutar el análisis léxico utilizando tu lexer en Java
    private void analyzeText(String text, TextArea outputArea) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new StringReader(text));
            DemoLexer lexer = new DemoLexer(reader);
            Token token = lexer.yylex();

            Map<String, TreeMap<String, List<Integer>>> tokenMap = new HashMap<>();
            int lineNumber = 1;

            while (token.getTokenType() != TokenConstant.EOF) {
                if (token.getTokenType() == TokenConstant.NEWLINE) {
                    lineNumber++;
                    token = lexer.yylex();
                } else {
                    tokenMap.putIfAbsent(token.getLexema(), new TreeMap<>());
                    TreeMap<String, List<Integer>> innerMap = tokenMap.get(token.getLexema());

                    innerMap.putIfAbsent(token.getTokenType().name(), new ArrayList<>());
                    List<Integer> lineNumbers = innerMap.get(token.getTokenType().name());
                    lineNumbers.add(lineNumber);
                    token = lexer.yylex();
                }
            }

            // Construir el resultado basado en el mapa de tokens
            result.append("LISTA DE TOKENS Y OCURRENCIAS\n");
            result.append(String.format("%-20s %-20s %-30s%n", "Token", "Tipo de Token", "Línea"));
            result.append("---------------------------------------------------------------\n");
            result.append(buildTokenOutput(tokenMap));

        } catch (Exception e) {
            result.append("Error: ").append(e.getMessage());
        }

        outputArea.setText(result.toString());
    }

    private String buildTokenOutput(Map<String, TreeMap<String, List<Integer>>> tokenMap) {
        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, TreeMap<String, List<Integer>>> tokenEntry : tokenMap.entrySet()) {
            String token = tokenEntry.getKey();
            TreeMap<String, List<Integer>> innerMap = tokenEntry.getValue();

            for (Map.Entry<String, List<Integer>> typeEntry : innerMap.entrySet()) {
                String tokenType = typeEntry.getKey();
                List<Integer> lineNumbers = typeEntry.getValue();
                StringBuilder lineInfo = new StringBuilder();
                Map<Integer, Integer> lineCount = new LinkedHashMap<>();

                for (Integer lineNumber : lineNumbers) {
                    lineCount.put(lineNumber, lineCount.getOrDefault(lineNumber, 0) + 1);
                }

                for (Map.Entry<Integer, Integer> entry : lineCount.entrySet()) {
                    lineInfo.append(entry.getKey());
                    if (entry.getValue() > 1) {
                        lineInfo.append("(").append(entry.getValue()).append(")");
                    }
                    lineInfo.append(", ");
                }

                if (lineInfo.length() > 0) {
                    lineInfo.setLength(lineInfo.length() - 2);
                }

                output.append(String.format("%-20s %-20s %-30s%n", token, tokenType, lineInfo.toString()));
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
