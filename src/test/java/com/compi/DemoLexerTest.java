package com.compi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoLexerTest {

    @Test
    public void matchId() throws IOException {
        String testString = "id1";
        Reader stringReader = new StringReader(testString);
        DemoLexer lexer = new DemoLexer(stringReader);
        Token token = lexer.yylex();//yylex para obtener el token
        Assertions.assertEquals(TokenConstant.ID, token.getTokenType());
    }

    @Test
    public void matchNum() throws IOException {
        String testString = "6546";
        Reader stringReader = new StringReader(testString);
        DemoLexer lexer = new DemoLexer(stringReader);
        Token token = lexer.yylex();//yylex para obtener el token

        // Imprimir el tipo de token para depuración
        System.out.println("Token Type: " + token.getTokenType());
        System.out.println("Token Text: " + token.getTokenText());

        Assertions.assertEquals(TokenConstant.NUM, token.getTokenType());
    }

    @Test
    public void noMatch() throws IOException {
        String testString = "@";

        Reader stringReader = new StringReader(testString);
        DemoLexer lexer = new DemoLexer(stringReader);
        Token token = lexer.yylex();//yylex para obtener el token
        Assertions.assertEquals(TokenConstant.ERROR, token.getTokenType());
    }
}
