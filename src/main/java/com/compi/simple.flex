// * Archivo de especificación léxica *
package com.compi;

import java_cup.runtime.Symbol;
import TokenTable.TokenInfo; // Importar TokenInfo para manejo de información de tokens
import java.util.ArrayList;

%%

// Parte 2: OPCIONES Y DECLARACIONES
%public
%class DemoLexer
%{
    private ArrayList<String> lexicalErrors = new ArrayList<>();
    private int lineNumber = 1;

    // Método para acceder a los errores léxicos
    public ArrayList<String> getLexicalErrors() {
        return lexicalErrors;
    }

    // Método para incrementar el número de línea
    private void incrementLineNumber() {
        lineNumber++;
    }

    private TokenInfo createTokenInfo(String lexeme) {
        return new TokenInfo((lexeme != null) ? lexeme : "", lineNumber, yycolumn); // Manejo de valores nulos en lexeme
    }
%}

// Macros con expresiones regulares para usar en reglas
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r]
newline = [\n]

%type Symbol

%%
// Parte 3: REGLAS LÉXICAS

// Comentarios de línea
"//".* { /* DO NOTHING */ }

// Comentarios de bloque
"/\\([^]|\\+[^/])\\+/" { /* DO NOTHING */ }

// Comentario sin terminar
"/\\*" {
    lexicalErrors.add("Error: Comentario sin terminar en línea " + lineNumber);
    return new Symbol(sym.ERROR, createTokenInfo(yytext()));
}

// Palabras reservadas de C
"int"       { return new Symbol(sym.INT, createTokenInfo(yytext())); }
"float"     { return new Symbol(sym.FLOAT, createTokenInfo(yytext())); }
"char"      { return new Symbol(sym.CHAR, createTokenInfo(yytext())); }
"if"        { return new Symbol(sym.IF, createTokenInfo(yytext())); }
"while"     { return new Symbol(sym.WHILE, createTokenInfo(yytext())); }
"return"    { return new Symbol(sym.RETURN, createTokenInfo(yytext())); }
"double"    { return new Symbol(sym.DOUBLE, createTokenInfo(yytext())); }
"const"     { return new Symbol(sym.CONST, createTokenInfo(yytext())); }
"unsigned"  { return new Symbol(sym.UNSIGNED, createTokenInfo(yytext())); }
"auto"      { return new Symbol(sym.AUTO, createTokenInfo(yytext())); }
"break"     { return new Symbol(sym.BREAK, createTokenInfo(yytext())); }
"case"      { return new Symbol(sym.CASE, createTokenInfo(yytext())); }
"continue"  { return new Symbol(sym.CONTINUE, createTokenInfo(yytext())); }
"default"   { return new Symbol(sym.DEFAULT, createTokenInfo(yytext())); }
"do"        { return new Symbol(sym.DO, createTokenInfo(yytext())); }
"else"      { return new Symbol(sym.ELSE, createTokenInfo(yytext())); }
"enum"      { return new Symbol(sym.ENUM, createTokenInfo(yytext())); }
"extern"    { return new Symbol(sym.EXTERN, createTokenInfo(yytext())); }
"for"       { return new Symbol(sym.FOR, createTokenInfo(yytext())); }
"goto"      { return new Symbol(sym.GOTO, createTokenInfo(yytext())); }
"long"      { return new Symbol(sym.LONG, createTokenInfo(yytext())); }
"register"  { return new Symbol(sym.REGISTER, createTokenInfo(yytext())); }
"short"     { return new Symbol(sym.SHORT, createTokenInfo(yytext())); }
"signed"    { return new Symbol(sym.SIGNED, createTokenInfo(yytext())); }
"sizeof"    { return new Symbol(sym.SIZEOF, createTokenInfo(yytext())); }
"static"    { return new Symbol(sym.STATIC, createTokenInfo(yytext())); }
"struct"    { return new Symbol(sym.STRUCT, createTokenInfo(yytext())); }
"switch"    { return new Symbol(sym.SWITCH, createTokenInfo(yytext())); }
"typedef"   { return new Symbol(sym.TYPEDEF, createTokenInfo(yytext())); }
"union"     { return new Symbol(sym.UNION, createTokenInfo(yytext())); }
"void"      { return new Symbol(sym.VOID, createTokenInfo(yytext())); }
"volatile"  { return new Symbol(sym.VOLATILE, createTokenInfo(yytext())); }

// Operadores y delimitadores
"=="        { return new Symbol(sym.IGUALDAD, createTokenInfo(yytext())); }
"!="        { return new Symbol(sym.NO_IGUAL, createTokenInfo(yytext())); }
"+"         { return new Symbol(sym.ADITIVO, createTokenInfo(yytext())); }
"-"         { return new Symbol(sym.SUSTRACTIVO, createTokenInfo(yytext())); }
"*"         { return new Symbol(sym.MULTIPLICACION, createTokenInfo(yytext())); }
"/"         { return new Symbol(sym.DIVISION, createTokenInfo(yytext())); }
"="         { return new Symbol(sym.ASIGNACION, createTokenInfo(yytext())); }
"("         { return new Symbol(sym.PARENTESIS_IZQ, createTokenInfo(yytext())); }
")"         { return new Symbol(sym.PARENTESIS_DER, createTokenInfo(yytext())); }
"{"         { return new Symbol(sym.LLAVE_IZQ, createTokenInfo(yytext())); }
"}"         { return new Symbol(sym.LLAVE_DER, createTokenInfo(yytext())); }
";"         { return new Symbol(sym.PUNTO_Y_COMA, createTokenInfo(yytext())); }
","         { return new Symbol(sym.COMA, createTokenInfo(yytext())); }
"++"        { return new Symbol(sym.INCREMENTO, createTokenInfo(yytext())); }
"--"        { return new Symbol(sym.DECREMENTO, createTokenInfo(yytext())); }
":"         { return new Symbol(sym.COLON, createTokenInfo(yytext())); }
">="        { return new Symbol(sym.MAYOR_IGUAL, createTokenInfo(yytext())); }
"<="        { return new Symbol(sym.MENOR_IGUAL, createTokenInfo(yytext())); }
">"         { return new Symbol(sym.MAYOR, createTokenInfo(yytext())); }
"<"         { return new Symbol(sym.MENOR, createTokenInfo(yytext())); }
"&"         { return new Symbol(sym.AND_BINARIO, createTokenInfo(yytext())); }
"|"         { return new Symbol(sym.OR_BINARIO, createTokenInfo(yytext())); }
"^"         { return new Symbol(sym.XOR_BINARIO, createTokenInfo(yytext())); }
"%"         { return new Symbol(sym.MODULO, createTokenInfo(yytext())); }
"<<"        { return new Symbol(sym.DESPLAZAMIENTO_IZQ, createTokenInfo(yytext())); }
">>"        { return new Symbol(sym.DESPLAZAMIENTO_DER, createTokenInfo(yytext())); }
"+="        { return new Symbol(sym.ASIGNACION_ADITIVA, createTokenInfo(yytext())); }
"-="        { return new Symbol(sym.ASIGNACION_SUSTRACTIVA, createTokenInfo(yytext())); }
"*="        { return new Symbol(sym.ASIGNACION_MULTIPLICATIVA, createTokenInfo(yytext())); }
"/="        { return new Symbol(sym.ASIGNACION_DIVISIVA, createTokenInfo(yytext())); }
"%="        { return new Symbol(sym.ASIGNACION_MODULO, createTokenInfo(yytext())); }
"&&"        { return new Symbol(sym.AND_LOGICO, createTokenInfo(yytext())); }
"||"        { return new Symbol(sym.OR_LOGICO, createTokenInfo(yytext())); }
"!"         { return new Symbol(sym.NOT_LOGICO, createTokenInfo(yytext())); }
"~"         { return new Symbol(sym.COMPLEMENTO_BINARIO, createTokenInfo(yytext())); }

// Literales de cadena
\"([^\"\\]|\\.)*\" { return new Symbol(sym.STRING, createTokenInfo(yytext())); }
\"([^\"\\]|\\.)*   { lexicalErrors.add("Error: Cadena sin cerrar en línea " + lineNumber); return new Symbol(sym.ERROR, createTokenInfo(yytext())); }

// Literales de caracteres
\'([^'\\]|\\.)\' { return new Symbol(sym.CHAR_LITERAL, createTokenInfo(yytext())); }
\'([^'\\]|\\.)?\' { lexicalErrors.add("Error: Carácter mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, createTokenInfo(yytext())); }

// Identificadores
{letter}({letter}|{digit})* { return new Symbol(sym.ID, createTokenInfo(yytext())); }
{letter}({whitespace}+{letter}|{whitespace}+{digit})* {
    lexicalErrors.add("Error: Identificador mal formado con espacios en línea " + lineNumber);
    return new Symbol(sym.ERROR, createTokenInfo(yytext()));
}

// Números
{digit}+ { return new Symbol(sym.NUM, createTokenInfo(yytext())); } // Números enteros
{digit}+"."{digit}+([eE][-+]?{digit}+) { return new Symbol(sym.NUM_CIENTIFICO, createTokenInfo(yytext())); }
{digit}+"."{digit}+ { return new Symbol(sym.NUM, createTokenInfo(yytext())); }
{digit}+"."{digit}*[eE] { lexicalErrors.add("Error: Número científico mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, createTokenInfo(yytext())); }

// Hexadecimales
0[xX][0-9a-fA-F]+ { return new Symbol(sym.NUM_HEX, createTokenInfo(yytext())); }
0[xX][^0-9a-fA-F]+ { lexicalErrors.add("Error: Número hexadecimal mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, createTokenInfo(yytext())); }

// Octales
"0"[0-7]+ { return new Symbol(sym.NUM_OCT, createTokenInfo(yytext())); }
"0"[8-9]+ { lexicalErrors.add("Error: Número octal mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, createTokenInfo(yytext())); }

// Espacios en blanco
{whitespace}+ { /* Ignorar espacios en blanco */ }

// Nueva línea
{newline} { incrementLineNumber(); return new Symbol(sym.NEWLINE, createTokenInfo(yytext())); }

// Manejo de errores léxicos (caracteres no reconocidos)
. {
    lexicalErrors.add("Error léxico en línea " + lineNumber + ": símbolo no reconocido '" + yytext() + "'");
    return new Symbol(sym.ERROR, createTokenInfo(yytext()));
}

// Fin de archivo (EOF)
<<EOF>> { return new Symbol(sym.EOF, createTokenInfo("")); } // Manejo de `value` como no-nulo
