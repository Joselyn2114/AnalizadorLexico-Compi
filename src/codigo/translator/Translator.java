package codigo.translator;

import codigo.lexer.Token;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Translator {

    private List<Token> tokens;
    private int currentTokenIndex = 0;
    private boolean in_loop = false;
    private boolean in_statement = false;
    private BufferedWriter writer;
    private List<SymbolTableEntry> symbolTable = new ArrayList<>();


    public Translator(List<Token> tokens, String outputFilePath) throws IOException {
        this.tokens = tokens;
        this.writer = new BufferedWriter(new FileWriter(outputFilePath));
    }

    private Token currentToken() {
        return tokens.get(currentTokenIndex);
    }

    private void advance() {
        if (currentTokenIndex < tokens.size()) {
            currentTokenIndex++;
        }
    }

    public void translate() throws IOException {
        try {
            while (currentTokenIndex < tokens.size()) {
                Token token = currentToken();
                switch (token.getType()) {
                    case T_dato:
                        writeToOutput(handleVariableDeclaration());
                        break;
                    case If:
                        writeToOutput(handleIf());
                        break;
                    case While:
                        writeToOutput(handleWhile());
                        break;
                    case Identificador:
                        writeToOutput(handleExpression());
                        break;
                    default:
                        advance();
                }
            }
        } finally {
            writer.close();
        }
    }

    private void writeToOutput(String assembly) throws IOException {
        writer.write(assembly);
        writer.newLine();
    }

    private String handleVariableDeclaration() {
        Token dataType = currentToken();
        advance();
        Token identifier = currentToken();
        advance();
        
        addSymbol(identifier.getLexeme(), dataType.getLexeme(), "global");
        
        return String.format("; Declare variable %s\n%s:\tRESW 1\n",
                identifier.getLexeme(), identifier.getLexeme());
    }

    private String handleIf() {
        this.in_statement = true;
        StringBuilder assembly = new StringBuilder("; If statement\n");
        advance(); // Consume 'if'
        advance(); // Consume '('
        assembly.append(handleCondition());
        advance(); // Consume ')'
        assembly.append("IF_TRUE:\n");
        advance(); // Consume '{'
        return assembly.toString();
    }

    private String handleWhile() {
        this.in_loop = true;
        StringBuilder assembly = new StringBuilder("; While loop\n");
        assembly.append("WHILE_START:\n");
        advance(); // Consume 'while'
        advance(); // Consume '('
        assembly.append(handleCondition());
        advance(); // Consume ')'
        assembly.append("IF_TRUE:\n");
        advance(); // Consume '{'
        return assembly.toString();
    }

    private String handleCondition() {
        StringBuilder assembly = new StringBuilder();
        Token leftOperand = currentToken();
        advance();
        Token operator = currentToken();
        advance();
        Token rightOperand = currentToken();
        advance();

        String conditionOperator;
        switch (operator.getLexeme()) {
            case ">":
                conditionOperator = "JG";
                break;
            case "<":
                conditionOperator = "JL";
                break;
            case "==":
                conditionOperator = "JE";
                break;
            case "!=":
                conditionOperator = "JNE";
                break;
            default:
                conditionOperator = "Unsoported Operator";
        }

        assembly.append(String.format("; Condition %s %s %s\nMOV AX, %s\nCMP AX, %s\n%s IF_TRUE\n",
                leftOperand.getLexeme(),
                operator.getLexeme(),
                rightOperand.getLexeme(),
                leftOperand.getLexeme(),
                rightOperand.getLexeme(),
                conditionOperator));
        return assembly.toString();
    }

    private String handleExpression() {
        Token identifier = currentToken();
        advance();
        Token operator = currentToken();
        advance();
        Token operand = currentToken();
        advance();

        String assembly;
        switch (operator.getLexeme()) {
            case "=":
                assembly = String.format("; Assign %s = %s\nMOV AX, %s\nMOV %s, AX\n",
                        identifier.getLexeme(),
                        operand.getLexeme(),
                        operand.getLexeme(),
                        identifier.getLexeme());
                break;
            case "+":
                assembly = String.format("; Add %s += %s\nMOV AX, %s\nADD %s, AX\n",
                        identifier.getLexeme(),
                        operand.getLexeme(),
                        operand.getLexeme(),
                        identifier.getLexeme());
                break;
            case "-":
                assembly = String.format("; Subtract %s -= %s\nMOV AX, %s\nSUB %s, AX\n",
                        identifier.getLexeme(),
                        operand.getLexeme(),
                        operand.getLexeme(),
                        identifier.getLexeme());
                break;
            case "}":
                if (in_loop) {
                    assembly = "JMP WHILE_START\nENDIF:\n";
                    this.in_loop = false;
                } else if (in_statement) {
                    assembly = "ENDIF:\n";
                    this.in_statement = false;
                } else {
                    assembly = "";
                }
                break;
            default:
                assembly = "";
        }
        return assembly;
    }
    
    
    private void addSymbol(String name, String type, String scope) {
        symbolTable.add(new SymbolTableEntry(name, type, scope));
    }
    
    public List<SymbolTableEntry> getSymbolTable() {
        return this.symbolTable;
    }

}
