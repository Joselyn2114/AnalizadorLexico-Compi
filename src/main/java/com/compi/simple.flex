// ** Archivo de especificación léxica **
package com.compi; // Declara el paquete donde quiero generar mi clase

%%
// Parte 2: OPCIONES Y DECLARACIONES
%public
%class DemoLexer

// Macros con expresiones regulares para usar en reglas
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r]
newline = [\n]

%type Token

%%
// Parte 3: REGLAS LÉXICAS

// Comentarios de línea: coincidir desde // hasta el final de la línea, luego hacer nada
"//".*                                    { /* DO NOTHING */ }

// Comentarios de bloque: coincidir secuencias de caracteres terminando con uno o más '*' seguidos de '/'
"/\\*([^*]|\\*+[^/*])*\\*+/"              { /* DO NOTHING */ }

// Comentario sin terminar: coincidir y producir un error fatal
"/\\*"                                    { System.err.println("Error: Comentario sin terminar."); }

// Palabras reservadas de C
"int"       { return new Token(TokenConstant.INT, yytext()); }
"float"     { return new Token(TokenConstant.FLOAT, yytext()); }
"char"      { return new Token(TokenConstant.CHAR, yytext()); }
"if"        { return new Token(TokenConstant.IF, yytext()); }
"while"     { return new Token(TokenConstant.WHILE, yytext()); }
"return"    { return new Token(TokenConstant.RETURN, yytext()); }
"double"    { return new Token(TokenConstant.DOUBLE, yytext()); }
"const"     { return new Token(TokenConstant.CONST, yytext()); }
"unsigned"  { return new Token(TokenConstant.UNSIGNED, yytext()); }
"auto"      { return new Token(TokenConstant.AUTO, yytext()); }
"break"     { return new Token(TokenConstant.BREAK, yytext()); }
"case"      { return new Token(TokenConstant.CASE, yytext()); }
"continue"  { return new Token(TokenConstant.CONTINUE, yytext()); }
"default"   { return new Token(TokenConstant.DEFAULT, yytext()); }
"do"        { return new Token(TokenConstant.DO, yytext()); }
"else"      { return new Token(TokenConstant.ELSE, yytext()); }
"enum"      { return new Token(TokenConstant.ENUM, yytext()); }
"extern"    { return new Token(TokenConstant.EXTERN, yytext()); }
"for"       { return new Token(TokenConstant.FOR, yytext()); }
"goto"      { return new Token(TokenConstant.GOTO, yytext()); }
"long"      { return new Token(TokenConstant.LONG, yytext()); }
"register"  { return new Token(TokenConstant.REGISTER, yytext()); }
"short"     { return new Token(TokenConstant.SHORT, yytext()); }
"signed"    { return new Token(TokenConstant.SIGNED, yytext()); }
"sizeof"    { return new Token(TokenConstant.SIZEOF, yytext()); }
"static"    { return new Token(TokenConstant.STATIC, yytext()); }
"struct"    { return new Token(TokenConstant.STRUCT, yytext()); }
"switch"    { return new Token(TokenConstant.SWITCH, yytext()); }
"typedef"   { return new Token(TokenConstant.TYPEDEF, yytext()); }
"union"     { return new Token(TokenConstant.UNION, yytext()); }
"void"      { return new Token(TokenConstant.VOID, yytext()); }
"volatile"  { return new Token(TokenConstant.VOLATILE, yytext()); }

// Operadores y delimitadores
"=="        { return new Token(TokenConstant.IGUALDAD, yytext()); }
"!="        { return new Token(TokenConstant.NO_IGUAL, yytext()); }
"+"         { return new Token(TokenConstant.ADITIVO, yytext()); }
"-"         { return new Token(TokenConstant.SUSTRACTIVO, yytext()); }
"*"         { return new Token(TokenConstant.MULTIPLICACION, yytext()); }
"/"         { return new Token(TokenConstant.DIVISION, yytext()); }
"="         { return new Token(TokenConstant.ASIGNACION, yytext()); }
"("         { return new Token(TokenConstant.PARENTESIS_IZQ, yytext()); }
")"         { return new Token(TokenConstant.PARENTESIS_DER, yytext()); }
"{"         { return new Token(TokenConstant.LLAVE_IZQ, yytext()); }
"}"         { return new Token(TokenConstant.LLAVE_DER, yytext()); }
";"         { return new Token(TokenConstant.PUNTO_Y_COMA, yytext()); }
","         { return new Token(TokenConstant.COMA, yytext()); }
"++"        { return new Token(TokenConstant.INCREMENTO, yytext()); }
"--"        { return new Token(TokenConstant.DECREMENTO, yytext()); }
">="        { return new Token(TokenConstant.MAYOR_IGUAL, yytext()); }
"<="        { return new Token(TokenConstant.MENOR_IGUAL, yytext()); }
">"         { return new Token(TokenConstant.MAYOR, yytext()); }
"<"         { return new Token(TokenConstant.MENOR, yytext()); }
"&"         { return new Token(TokenConstant.AND_BINARIO, yytext()); }
"|"         { return new Token(TokenConstant.OR_BINARIO, yytext()); }
"^"         { return new Token(TokenConstant.XOR_BINARIO, yytext()); }
"%"         { return new Token(TokenConstant.MODULO, yytext()); }
"<<"        { return new Token(TokenConstant.DESPLAZAMIENTO_IZQ, yytext()); }
">>"        { return new Token(TokenConstant.DESPLAZAMIENTO_DER, yytext()); }
"+="        { return new Token(TokenConstant.ASIGNACION_ADITIVA, yytext()); }
"-="        { return new Token(TokenConstant.ASIGNACION_SUSTRACTIVA, yytext()); }
"*="        { return new Token(TokenConstant.ASIGNACION_MULTIPLICATIVA, yytext()); }


// Identificadores
{letter}({letter}|{digit})* { return new Token(TokenConstant.ID, yytext()); }

// Entero
//{digit}+ { return new Token(TokenConstant.NUM, yytext());} // Números enteros
{digit}+ {
    System.out.println("Regla activada: Números enteros, valor: " + yytext());
    return new Token(TokenConstant.NUM, yytext());
}

// Números
{digit}+"."{digit}+([eE][-+]?{digit}+) { return new Token(TokenConstant.NUM_CIENTIFICO, yytext()); } // Números científicos
{digit}+"."{digit}+ { return new Token(TokenConstant.NUM, yytext()); } // Números decimales

// Espacios en blanco
{whitespace}+ { /* Ignorar espacios en blanco */ }

// Nueva línea
{newline} { return new Token(TokenConstant.NEWLINE, yytext()); }

// Manejo de errores
//. { return new Token(TokenConstant.ERROR, yytext()); }
. {
    System.out.println("Regla activada: Error, carácter no reconocido: " + yytext());
    return new Token(TokenConstant.ERROR, yytext());
}

// Fin de archivo (EOF)
<<EOF>> { return new Token(TokenConstant.EOF, null); }
