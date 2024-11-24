/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo.Semantic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPC_DC
 */
public class SemanticAnalyzer {
    private final SymbolTable symbolTable = new SymbolTable();
    private final List<SemanticError> errors = new ArrayList<>();
    private final Stack<String> blockContext = new Stack<>();

    public void declareVariable(String name, String type, int line) {
        try {
            symbolTable.define(name, new SemanticSymbol(name, type, line));
        } catch (SemanticException ex) {
            Logger.getLogger(SemanticAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkVariable(String name, int line) {
        try {
            symbolTable.lookup(name);
        } catch (SemanticException e) {
            errors.add(new SemanticError(e.getMessage(), line));
        }
    }

    public void checkConstantFolding(Expression expr, int line) {
        if (expr.isConstantExpression()) {
            int result = expr.evaluate();
            Expression constantExpr = new ConstantExpression(result);
            System.out.println("Optimización constante en la línea " + line + ": reemplazando " + expr + " con " + constantExpr);
        }
    }
    public void checkConstantPropagation() {
            for (SemanticSymbol symbol : symbolTable.getAllSymbols()) {
                if (symbol.isConstant()) {
                    propagateConstant(symbol);
                }
            }
        }
        private void propagateConstant(SemanticSymbol symbol) {
        String variableName = symbol.getName();
        int constantValue = symbol.getConstantValue();
        List<Expression> expressions = new ArrayList<>();

        for (Expression expr : expressions) {
            expr.replaceVariableWithConstant(variableName, constantValue);
        }
    }

    public void checkBreakContinueInLoop(boolean inLoop, int line) {
        if (!inLoop) {
            errors.add(new SemanticError("'break' o 'continue' fuera de un bucle.", line));
        }
    }
    public void checkVariableDefined(String name, int line) {
        try {
            symbolTable.lookup(name);
        } catch (SemanticException e) {
            errors.add( new SemanticError("Variable '" + name + "' no definida.", line));
        }
        
    }

    public void enterLoop() {
        blockContext.push("loop");
    }
    public void exitLoop() {
        if (!blockContext.isEmpty() && blockContext.peek().equals("loop")) {
            blockContext.pop();
        }
    }
    public void checkBreakUsage(int line) {
        if (!blockContext.contains("loop")) {
            errors.add(new  SemanticError("Error 'break' solo se permite dentro de bucles", line));
        }
    }

    public void checkContinueUsage(int line) {
        if (!blockContext.contains("loop")) {
           errors.add(new  SemanticError("Error 'continue' solo se permite dentro de bucles", line));
        }
    }
    

    public List<SemanticError> getErrors() {
        return errors;
    }
}

