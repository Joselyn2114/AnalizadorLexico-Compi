<<<<<<< Updated upstream
// ** Archivo de especificación léxica **
package com.compi; // Declara el paquete donde quiero generar mi clase
=======
// * Archivo de especificación léxica *
package com.compi;
>>>>>>> Stashed changes

import java_cup.runtime.Symbol;

%%

%{
    // Declaración de las variables de línea y columna
    private int lineNumber = 1;
    private int columnNumber = 1;
%}

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

// Manejo de nueva línea con actualización de línea y columna
{newline} {
    lineNumber++;
    columnNumber = 1;
    return new Symbol(sym.NEWLINE, lineNumber, columnNumber, yytext());
}

// Comentarios de línea
"//".* { /* DO NOTHING */ }

// Comentarios de bloque
<<<<<<< Updated upstream
"/\\*([^*]|\\*+[^/*])*\\*+/" { /* DO NOTHING */ }
=======
"/\\([^]|\\+[^/])\\+/" { /* DO NOTHING */ }
>>>>>>> Stashed changes

// Comentario sin terminar
"/\\*" {
    System.err.println("Error: Comentario sin terminar en línea " + lineNumber + ".");
    return new Symbol(sym.ERROR, lineNumber, columnNumber, "Unfinished comment");
}

// Palabras reservadas de C
"int"       { return new Symbol(sym.INT, lineNumber, columnNumber, yytext()); }
"float"     { return new Symbol(sym.FLOAT, lineNumber, columnNumber, yytext()); }
"char"      { return new Symbol(sym.CHAR, lineNumber, columnNumber, yytext()); }
"if"        { return new Symbol(sym.IF, lineNumber, columnNumber, yytext()); }
"while"     { return new Symbol(sym.WHILE, lineNumber, columnNumber, yytext()); }
"return"    { return new Symbol(sym.RETURN, lineNumber, columnNumber, yytext()); }
"double"    { return new Symbol(sym.DOUBLE, lineNumber, columnNumber, yytext()); }
"const"     { return new Symbol(sym.CONST, lineNumber, columnNumber, yytext()); }
"unsigned"  { return new Symbol(sym.UNSIGNED, lineNumber, columnNumber, yytext()); }
"auto"      { return new Symbol(sym.AUTO, lineNumber, columnNumber, yytext()); }
"break"     { return new Symbol(sym.BREAK, lineNumber, columnNumber, yytext()); }
"case"      { return new Symbol(sym.CASE, lineNumber, columnNumber, yytext()); }
"continue"  { return new Symbol(sym.CONTINUE, lineNumber, columnNumber, yytext()); }
"default"   { return new Symbol(sym.DEFAULT, lineNumber, columnNumber, yytext()); }
"do"        { return new Symbol(sym.DO, lineNumber, columnNumber, yytext()); }
"else"      { return new Symbol(sym.ELSE, lineNumber, columnNumber, yytext()); }
"enum"      { return new Symbol(sym.ENUM, lineNumber, columnNumber, yytext()); }
"extern"    { return new Symbol(sym.EXTERN, lineNumber, columnNumber, yytext()); }
"for"       { return new Symbol(sym.FOR, lineNumber, columnNumber, yytext()); }
"goto"      { return new Symbol(sym.GOTO, lineNumber, columnNumber, yytext()); }
"long"      { return new Symbol(sym.LONG, lineNumber, columnNumber, yytext()); }
"register"  { return new Symbol(sym.REGISTER, lineNumber, columnNumber, yytext()); }
"short"     { return new Symbol(sym.SHORT, lineNumber, columnNumber, yytext()); }
"signed"    { return new Symbol(sym.SIGNED, lineNumber, columnNumber, yytext()); }
"sizeof"    { return new Symbol(sym.SIZEOF, lineNumber, columnNumber, yytext()); }
"static"    { return new Symbol(sym.STATIC, lineNumber, columnNumber, yytext()); }
"struct"    { return new Symbol(sym.STRUCT, lineNumber, columnNumber, yytext()); }
"switch"    { return new Symbol(sym.SWITCH, lineNumber, columnNumber, yytext()); }
"typedef"   { return new Symbol(sym.TYPEDEF, lineNumber, columnNumber, yytext()); }
"union"     { return new Symbol(sym.UNION, lineNumber, columnNumber, yytext()); }
"void"      { return new Symbol(sym.VOID, lineNumber, columnNumber, yytext()); }
"volatile"  { return new Symbol(sym.VOLATILE, lineNumber, columnNumber, yytext()); }

// Operadores y delimitadores
<<<<<<< Updated upstream
"=="        { return new Symbol(sym.IGUALDAD, lineNumber, columnNumber, yytext()); }
"!="        { return new Symbol(sym.NO_IGUAL, lineNumber, columnNumber, yytext()); }
"+"         { return new Symbol(sym.ADITIVO, lineNumber, columnNumber, yytext()); }
"-"         { return new Symbol(sym.SUSTRACTIVO, lineNumber, columnNumber, yytext()); }
"*"         { return new Symbol(sym.MULTIPLICACION, lineNumber, columnNumber, yytext()); }
"/"         { return new Symbol(sym.DIVISION, lineNumber, columnNumber, yytext()); }
"="         { return new Symbol(sym.ASIGNACION, lineNumber, columnNumber, yytext()); }
"("         { return new Symbol(sym.PARENTESIS_IZQ, lineNumber, columnNumber, yytext()); }
")"         { return new Symbol(sym.PARENTESIS_DER, lineNumber, columnNumber, yytext()); }
"{"         { return new Symbol(sym.LLAVE_IZQ, lineNumber, columnNumber, yytext()); }
"}"         { return new Symbol(sym.LLAVE_DER, lineNumber, columnNumber, yytext()); }
";"         { return new Symbol(sym.PUNTO_Y_COMA, lineNumber, columnNumber, yytext()); }
","         { return new Symbol(sym.COMA, lineNumber, columnNumber, yytext()); }
"++"        { return new Symbol(sym.INCREMENTO, lineNumber, columnNumber, yytext()); }
"--"        { return new Symbol(sym.DECREMENTO, lineNumber, columnNumber, yytext()); }
">="        { return new Symbol(sym.MAYOR_IGUAL, lineNumber, columnNumber, yytext()); }
"<="        { return new Symbol(sym.MENOR_IGUAL, lineNumber, columnNumber, yytext()); }
">"         { return new Symbol(sym.MAYOR, lineNumber, columnNumber, yytext()); }
"<"         { return new Symbol(sym.MENOR, lineNumber, columnNumber, yytext()); }
"&"         { return new Symbol(sym.AND_BINARIO, lineNumber, columnNumber, yytext()); }
"|"         { return new Symbol(sym.OR_BINARIO, lineNumber, columnNumber, yytext()); }
"^"         { return new Symbol(sym.XOR_BINARIO, lineNumber, columnNumber, yytext()); }
"%"         { return new Symbol(sym.MODULO, lineNumber, columnNumber, yytext()); }
"<<"        { return new Symbol(sym.DESPLAZAMIENTO_IZQ, lineNumber, columnNumber, yytext()); }
">>"        { return new Symbol(sym.DESPLAZAMIENTO_DER, lineNumber, columnNumber, yytext()); }
"+="        { return new Symbol(sym.ASIGNACION_ADITIVA, lineNumber, columnNumber, yytext()); }
"-="        { return new Symbol(sym.ASIGNACION_SUSTRACTIVA, lineNumber, columnNumber, yytext()); }
"*="        { return new Symbol(sym.ASIGNACION_MULTIPLICATIVA, lineNumber, columnNumber, yytext()); }
"/="        { return new Symbol(sym.ASIGNACION_DIVISIVA, lineNumber, columnNumber, yytext()); }
"%="        { return new Symbol(sym.ASIGNACION_MODULO, lineNumber, columnNumber, yytext()); }
"&&"        { return new Symbol(sym.AND_LOGICO, lineNumber, columnNumber, yytext()); }
"||"        { return new Symbol(sym.OR_LOGICO, lineNumber, columnNumber, yytext()); }
"!"         { return new Symbol(sym.NOT_LOGICO, lineNumber, columnNumber, yytext()); }
"~"         { return new Symbol(sym.COMPLEMENTO_BINARIO, lineNumber, columnNumber, yytext()); }

// Literales de cadena
\"([^\"\\]|\\.)*\" { return new Symbol(sym.STRING, lineNumber, columnNumber, yytext()); }

// Literales de caracteres
\'([^'\\]|\\.)\' { return new Symbol(sym.CHAR_LITERAL, lineNumber, columnNumber, yytext()); }

// Identificadores
{letter}({letter}|{digit})* {
    Symbol sym = new Symbol(sym.ID, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}

// Números
{digit}+ {
    Symbol sym = new Symbol(sym.NUM, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}
{digit}+"."{digit}+([eE][-+]?{digit}+) {
    Symbol sym = new Symbol(sym.NUM_CIENTIFICO, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}
{digit}+"."{digit}+ {
    Symbol sym = new Symbol(sym.NUM, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}

// Hexadecimales
0[xX][0-9a-fA-F]+ {
    Symbol sym = new Symbol(sym.NUM_HEX, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}

// Octales
"0"[0-7]+ {
    Symbol sym = new Symbol(sym.NUM_OCT, lineNumber, columnNumber, yytext());
    columnNumber += yylength();
    return sym;
}
=======
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
":"         { return new Symbol(sym.COLON, yytext()); }
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
\"([^\"\\]|\\.)*   { lexicalErrors.add("Error: Cadena sin cerrar en línea " + lineNumber); return new Symbol(sym.ERROR, yytext()); }

// Literales de caracteres
\'([^'\\]|\\.)\' { return new Symbol(sym.CHAR_LITERAL, yytext()); }
\'([^'\\]|\\.)?\' { lexicalErrors.add("Error: Carácter mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, yytext()); }

// Identificadores
{letter}({letter}|{digit})* { return new Symbol(sym.ID, yytext()); }
{letter}({whitespace}+{letter}|{whitespace}+{digit})* {
    lexicalErrors.add("Error: Identificador mal formado con espacios en línea " + lineNumber);
    return new Symbol(sym.ERROR, yytext());
}

// Números
{digit}+ { return new Symbol(sym.NUM, yytext()); } // Números enteros
{digit}+"."{digit}+([eE][-+]?{digit}+) { return new Symbol(sym.NUM_CIENTIFICO, yytext()); }
{digit}+"."{digit}+ { return new Symbol(sym.NUM, yytext()); }
{digit}+"."{digit}*[eE] { lexicalErrors.add("Error: Número científico mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, yytext()); }

// Hexadecimales
0[xX][0-9a-fA-F]+ { return new Symbol(sym.NUM_HEX, yytext()); }
0[xX][^0-9a-fA-F]+ { lexicalErrors.add("Error: Número hexadecimal mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, yytext()); }

// Octales
"0"[0-7]+ { return new Symbol(sym.NUM_OCT, yytext()); }
"0"[8-9]+ { lexicalErrors.add("Error: Número octal mal formado en línea " + lineNumber); return new Symbol(sym.ERROR, yytext()); }
>>>>>>> Stashed changes

// Espacios en blanco
{whitespace}+ { /* Ignorar espacios en blanco */ }

// Nueva línea
{newline} {
    lineNumber++;
    columnNumber = 1;
    return new Symbol(sym.NEWLINE, yytext());
}

// Manejo de errores léxicos con número de línea y columna
. {
    System.err.println("Error léxico en línea " + lineNumber + ", columna " + columnNumber + ": carácter no reconocido '" + yytext() + "'");
    columnNumber += yylength();
    return new Symbol(sym.ERROR, yytext());
}

// Fin de archivo (EOF)
<<EOF>> { return new Symbol(sym.EOF, null); }