package codigo.Semantic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author XPC_DC
 */
public class SemanticError {
    private final String message;
    private final int line;

    public SemanticError(String message, int line) {
        this.message = message;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Error en línea " + line + ": " + message;
    }
}

