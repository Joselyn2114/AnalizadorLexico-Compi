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

// Operadores y delimitadores
"=="        { return new Token(TokenConstant.IGUALDAD, yytext()); }
"!="        { return new Token(TokenConstant.NOT_EQUAL, yytext()); }
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

// Identificadores
{letter}({letter}|{digit})* { return new Token(TokenConstant.ID, yytext()); }

// Números
{digit}+"."{digit}+([eE][-+]?{digit}+) { return new Token(TokenConstant.NUM_CIENTIFICO, yytext()); } // Números científicos
{digit}+"."{digit}+ { return new Token(TokenConstant.NUM, yytext()); } // Números decimales

// Espacios en blanco
{whitespace}+ { /* Ignorar espacios en blanco */ }

// Nueva línea
{newline} { return new Token(TokenConstant.NEWLINE, yytext()); }

// Manejo de errores
. { return new Token(TokenConstant.ERROR, yytext()); }

// Fin de archivo (EOF)
<<EOF>> { return new Token(TokenConstant.EOF, null); }
