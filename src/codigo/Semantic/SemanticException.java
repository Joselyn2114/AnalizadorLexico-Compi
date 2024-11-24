/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo.Semantic;

/**
 *
 * @author XPC_DC
 */
public class SemanticException extends Exception {
    private final int line;

    public SemanticException(String message, int line) {
        super(message);
        this.line = line;
    }

    public int getLine() {
        return line;
    }
}
