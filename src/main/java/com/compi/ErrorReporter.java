package com.compi;

import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    public static List<String> syntaxErrors = new ArrayList<>();

    public static void reportSyntaxError(String message, int line) {
        syntaxErrors.add("Error sintáctico en línea " + line + ": " + message);
    }
}
