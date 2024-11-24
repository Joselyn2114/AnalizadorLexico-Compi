/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo.Semantic;

/**
 *
 * @author XPC_DC
 */
public class ConstantExpression extends Expression {
    private final int value;

    public ConstantExpression(int value) {
        this.value = value;
    }

    @Override
    public boolean isConstantExpression() {
        return true;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

