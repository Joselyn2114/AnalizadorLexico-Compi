// ** Archivo de especificación léxica **
package com.compi;

import java_cup.runtime.Symbol;

%%

// Parte 2: OPCIONES Y DECLARACIONES
%public
%class DemoLexer

// Macros con expresiones regulares para usar en reglas
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r]
newline = [\n]

%type Symbol

%%
// Parte 3: REGLAS LÉXICAS

// Comentarios de línea
"//".*                                    { /* DO NOTHING */ }

// Comentarios de bloque
"/\\*([^*]|\\*+[^/*])*\\*+/"              { /* DO NOTHING */ }

// Comentario sin terminar
"/\\*"                                    { System.err.println("Error: Comentario sin terminar."); return new Symbol(sym.ERROR, yytext()); }

// Palabras reservadas de C
"int"       { return new Symbol(sym.INT, yytext()); }
"float"     { return new Symbol(sym.FLOAT, yytext()); }
"char"      { return new Symbol(sym.CHAR, yytext()); }
"if"        { return new Symbol(sym.IF, yytext()); }
"while"     { return new Symbol(sym.WHILE, yytext()); }
"return"    { return new Symbol(sym.RETURN, yytext()); }
"double"    { return new Symbol(sym.DOUBLE, yytext()); }
"const"     { return new Symbol(sym.CONST, yytext()); }
"unsigned"  { return new Symbol(sym.UNSIGNED, yytext()); }
"auto"      { return new Symbol(sym.AUTO, yytext()); }
"break"     { return new Symbol(sym.BREAK, yytext()); }
"case"      { return new Symbol(sym.CASE, yytext()); }
"continue"  { return new Symbol(sym.CONTINUE, yytext()); }
"default"   { return new Symbol(sym.DEFAULT, yytext()); }
"do"        { return new Symbol(sym.DO, yytext()); }
"else"      { return new Symbol(sym.ELSE, yytext()); }
"enum"      { return new Symbol(sym.ENUM, yytext()); }
"extern"    { return new Symbol(sym.EXTERN, yytext()); }
"for"       { return new Symbol(sym.FOR, yytext()); }
"goto"      { return new Symbol(sym.GOTO, yytext()); }
"long"      { return new Symbol(sym.LONG, yytext()); }
"register"  { return new Symbol(sym.REGISTER, yytext()); }
"short"     { return new Symbol(sym.SHORT, yytext()); }
"signed"    { return new Symbol(sym.SIGNED, yytext()); }
"sizeof"    { return new Symbol(sym.SIZEOF, yytext()); }
"static"    { return new Symbol(sym.STATIC, yytext()); }
"struct"    { return new Symbol(sym.STRUCT, yytext()); }
"switch"    { return new Symbol(sym.SWITCH, yytext()); }
"typedef"   { return new Symbol(sym.TYPEDEF, yytext()); }
"union"     { return new Symbol(sym.UNION, yytext()); }
"void"      { return new Symbol(sym.VOID, yytext()); }
"volatile"  { return new Symbol(sym.VOLATILE, yytext()); }

// Operadores y delimitadores
"=="        { return new Symbol(sym.IGUALDAD, yytext()); }
"!="        { return new Symbol(sym.NO_IGUAL, yytext()); }
"+"         { return new Symbol(sym.ADITIVO, yytext()); }
"-"         { return new Symbol(sym.SUSTRACTIVO, yytext()); }
"*"         { return new Symbol(sym.MULTIPLICACION, yytext()); }
"/"         { return new Symbol(sym.DIVISION, yytext()); }
"="         { return new Symbol(sym.ASIGNACION, yytext()); }
"("         { return new Symbol(sym.PARENTESIS_IZQ, yytext()); }
")"         { return new Symbol(sym.PARENTESIS_DER, yytext()); }
"{"         { return new Symbol(sym.LLAVE_IZQ, yytext()); }
"}"         { return new Symbol(sym.LLAVE_DER, yytext()); }
";"         { return new Symbol(sym.PUNTO_Y_COMA, yytext()); }
","         { return new Symbol(sym.COMA, yytext()); }
"++"        { return new Symbol(sym.INCREMENTO, yytext()); }
"--"        { return new Symbol(sym.DECREMENTO, yytext()); }
":"         { return new Symbol(sym.COLON, yytext()); }  // Agregado para 'COLON'
">="        { return new Symbol(sym.MAYOR_IGUAL, yytext()); }
"<="        { return new Symbol(sym.MENOR_IGUAL, yytext()); }
">"         { return new Symbol(sym.MAYOR, yytext()); }
"<"         { return new Symbol(sym.MENOR, yytext()); }
"&"         { return new Symbol(sym.AND_BINARIO, yytext()); }
"|"         { return new Symbol(sym.OR_BINARIO, yytext()); }
"^"         { return new Symbol(sym.XOR_BINARIO, yytext()); }
"%"         { return new Symbol(sym.MODULO, yytext()); }
"<<"        { return new Symbol(sym.DESPLAZAMIENTO_IZQ, yytext()); }
">>"        { return new Symbol(sym.DESPLAZAMIENTO_DER, yytext()); }
"+="        { return new Symbol(sym.ASIGNACION_ADITIVA, yytext()); }
"-="        { return new Symbol(sym.ASIGNACION_SUSTRACTIVA, yytext()); }
"*="        { return new Symbol(sym.ASIGNACION_MULTIPLICATIVA, yytext()); }
"/="        { return new Symbol(sym.ASIGNACION_DIVISIVA, yytext()); }
"%="        { return new Symbol(sym.ASIGNACION_MODULO, yytext()); }
"&&"        { return new Symbol(sym.AND_LOGICO, yytext()); }
"||"        { return new Symbol(sym.OR_LOGICO, yytext()); }
"!"         { return new Symbol(sym.NOT_LOGICO, yytext()); }
"~"         { return new Symbol(sym.COMPLEMENTO_BINARIO, yytext()); }

// Literales de cadena
\"([^\"\\]|\\.)*\" { return new Symbol(sym.STRING, yytext()); }

// Literales de caracteres
\'([^'\\]|\\.)\' { return new Symbol(sym.CHAR_LITERAL, yytext()); }

// Identificadores
{letter}({letter}|{digit})* { return new Symbol(sym.ID, yytext()); }

// Números
{digit}+ { return new Symbol(sym.NUM, yytext()); } // Números enteros
{digit}+"."{digit}+([eE][-+]?{digit}+) { return new Symbol(sym.NUM_CIENTIFICO, yytext()); } // Números científicos
{digit}+"."{digit}+ { return new Symbol(sym.NUM, yytext()); } // Números decimales

// Hexadecimales
0[xX][0-9a-fA-F]+ { return new Symbol(sym.NUM_HEX, yytext()); }

// Octales
"0"[0-7]+ { return new Symbol(sym.NUM_OCT, yytext()); }

// Espacios en blanco
{whitespace}+ { /* Ignorar espacios en blanco */ }

// Nueva línea
{newline} { return new Symbol(sym.NEWLINE, yytext()); }

// Manejo de errores
. {
    System.out.println("Error: carácter no reconocido: " + yytext());
    return new Symbol(sym.ERROR, yytext());
}

// Fin de archivo (EOF)
<<EOF>> { return new Symbol(sym.EOF, null); }
