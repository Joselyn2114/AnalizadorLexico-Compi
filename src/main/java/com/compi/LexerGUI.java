package com.compi;

import java_cup.runtime.Symbol;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerGUI extends Application {

    private Scene scene;
    private boolean isDarkMode = false; // Estado inicial del modo oscuro

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analizador Léxico");

        // Crear StyledTextArea para entrada de texto con resaltado de sintaxis
        StyleClassedTextArea inputArea = new StyleClassedTextArea();
        inputArea.setWrapText(true);
        inputArea.setParagraphGraphicFactory(LineNumberFactory.get(inputArea));
        inputArea.setPrefSize(600, 600);  // área de entrada

        Button analyzeButton = new Button("Analizar");
        analyzeButton.setMaxWidth(Double.MAX_VALUE); // Botón todo el ancho disponible

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefSize(600, 600);  //  área de salida

        // Botón para activar/desactivar el modo oscuro
        ToggleButton darkModeButton = new ToggleButton("Modo Oscuro");
        darkModeButton.setMaxWidth(Double.MAX_VALUE); // todo el ancho disponible
        darkModeButton.setOnAction(event -> toggleDarkMode());

        // Resaltar sintaxis mientras se escribe
        inputArea.textProperty().addListener((obs, oldText, newText) -> {
            applyHighlighting(inputArea, newText);
        });

        // Acción del botón "Analizar"
        analyzeButton.setOnAction(event -> {
            String inputText = inputArea.getText();
            outputArea.clear(); // Limpiar la salida anterior
           // analyzeText(inputText, outputArea);
        });

        // Crear layout vertical para el área de entrada
        VBox inputBox = new VBox(10, inputArea, analyzeButton, darkModeButton);
        inputBox.setPrefSize(600, 650); //  layout vertical

        // Crear SplitPane para organizar las ventanas en paralelo
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(inputBox, outputArea);
        splitPane.setDividerPositions(0.5); // Dividir al 50%

        // Crear la escena
        scene = new Scene(splitPane, 1200, 700);  // Tamaño más grande para más líneas visibles
        loadStyleSheet(); // Cargar estilos iniciales

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1200);  // Ajusta el tamaño mínimo de la ventana
        primaryStage.setMinHeight(700);
        primaryStage.show();
    }

    // Método para alternar el modo oscuro
    private void toggleDarkMode() {
        isDarkMode = !isDarkMode;
        loadStyleSheet();
    }

    // Método para cargar el archivo CSS correcto
    private void loadStyleSheet() {
        scene.getStylesheets().clear(); // Limpiar los estilos existentes
        String stylesheet = isDarkMode ? "dark-theme.css" : "light-theme.css";
        java.net.URL resource = getClass().getClassLoader().getResource(stylesheet);

        if (resource != null) {
            scene.getStylesheets().add(resource.toExternalForm());
        } else {
            System.err.println("No se pudo encontrar el archivo CSS: " + stylesheet);
        }
    }

    // Método para aplicar resaltado de sintaxis
    private void applyHighlighting(StyleClassedTextArea area, String text) {
        area.clearStyle(0, text.length());

        // Expresiones regulares para diferentes elementos de C
        String keywordsPattern = "\\b(int|float|double|char|void|if|else|while|for|return|struct|typedef|switch|case|break|continue|default)\\b";
        String commentPattern = "//[^\n]*|/\\*.*?\\*/";
        String stringPattern = "\"([^\"\\\\]|\\\\.)*\"";
        String charPattern = "'([^'\\\\]|\\\\.)*'";
        String numberPattern = "\\b\\d+\\.?\\d*\\b";
        String preprocessorPattern = "#[a-zA-Z_]+";
        String operatorPattern = "[+\\-*/=<>!&|%^~]";
        String identifierPattern = "\\b[A-Za-z_][A-Za-z0-9_]*\\b";

        // Combina todas las expresiones regulares
        Pattern pattern = Pattern.compile(
                "(?<KEYWORD>" + keywordsPattern + ")"
                        + "|(?<COMMENT>" + commentPattern + ")"
                        + "|(?<STRING>" + stringPattern + ")"
                        + "|(?<CHAR>" + charPattern + ")"
                        + "|(?<NUMBER>" + numberPattern + ")"
                        + "|(?<PREPROCESSOR>" + preprocessorPattern + ")"
                        + "|(?<OPERATOR>" + operatorPattern + ")"
                        + "|(?<IDENTIFIER>" + identifierPattern + ")"
        );

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.group("KEYWORD") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "keyword");
            } else if (matcher.group("COMMENT") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "comment");
            } else if (matcher.group("STRING") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "string");
            } else if (matcher.group("CHAR") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "char");
            } else if (matcher.group("NUMBER") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "number");
            } else if (matcher.group("PREPROCESSOR") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "preprocessor");
            } else if (matcher.group("OPERATOR") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "operator");
            } else if (matcher.group("IDENTIFIER") != null) {
                area.setStyleClass(matcher.start(), matcher.end(), "identifier");
            }
        }
    }

    // Método para ejecutar el análisis léxico utilizando tu lexer en Java
 /*   private void analyzeText(String text, TextArea outputArea) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new StringReader(text));
            DemoLexer lexer = new DemoLexer(reader);
            Symbol token = lexer.yylex();

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
   }*/

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
