package com.compi;

public class Token {

    private TokenConstant tokenType;
    private String lexema; //Es la cadena que concidió con la especificación dicha con la expresión regular.

    public Token(TokenConstant tokenType, String lexema) {
        this.tokenType = tokenType;
        this.lexema = lexema;
    }

    public TokenConstant getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenConstant tokenType) {
        this.tokenType = tokenType;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", lexema='" + lexema + '\'' +
                '}';
    }
}
