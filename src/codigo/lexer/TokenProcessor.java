package codigo.lexer;


import java.util.List;

public class TokenProcessor {
    public String processTokens(List<Token> tokens) {
        StringBuilder resultado = new StringBuilder("LINEA\tSIMBOLO\n");
        int currentLine = 1;

        for (Token token : tokens) {
            if (token.getLine() > currentLine) {
                currentLine = token.getLine();
                resultado.append("LINEA ").append(token.getLine()).append("\n");
            }
            resultado.append(String.format("<%s>\t%s\n", token.getType(), token.getLexeme()));
        }
        return resultado.toString();
    }
}
