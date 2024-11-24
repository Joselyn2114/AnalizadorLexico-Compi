/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo.Semantic;

/**
 *
 * @author XPC_DC
 */
public class SemanticSymbol {
    private final String name;
    private final String type;
    private final int line;
    private Integer constantValue;

    public SemanticSymbol(String name, String type, int line) {
        this.name = name;
        this.type = type;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLine() {
        return line;
    }
    
     public boolean isConstant() {
        return constantValue != null;
    }

    public int getConstantValue() {
        if (constantValue == null) throw new IllegalStateException("Variable no es constante");
        return constantValue;
    }
    
    public void setConstantValue(int value) {
        this.constantValue = value;
    }
    
    
}
