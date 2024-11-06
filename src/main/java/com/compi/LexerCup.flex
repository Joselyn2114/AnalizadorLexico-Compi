package com.compi;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol createSymbol(int type, Object value) {
        System.out.println("Token: " + sym.terminalNames[type] + ", Lexema: " + value);
        return new Symbol(type, (int) yychar, (int) yyline, value);
    }
    private Symbol createSymbol(int type) {
        System.out.println("Token: " + sym.terminalNames[type]);
        return new Symbol(type, (int) yychar, (int) yyline);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return createSymbol(sym.Comillas, yytext());}

/* Tipos de datos */
( byte | char | long | float | double ) {return createSymbol(sym.T_dato, yytext());}

/* Tipo de dato Int (Para el main) */
( "int" ) {return createSymbol(sym.Int, yytext());}

/* Tipo de dato String */
( String ) {return createSymbol(sym.Cadena, yytext());}

/* Palabra reservada If */
( if ) {return createSymbol(sym.If, yytext());}

/* Palabra reservada Else */
( else ) {return createSymbol(sym.Else, yytext());}

/* Palabra reservada Do */
( do ) {return createSymbol(sym.Do, yytext());}

/* Palabra reservada While */
( while ) {return createSymbol(sym.While, yytext());}

/* Palabra reservada For */
( for ) {return createSymbol(sym.For, yytext());}

/* Operador Igual */
( "=" ) {return createSymbol(sym.Igual, yytext());}

/* Operador Suma */
( "+" ) {return createSymbol(sym.Suma, yytext());}

/* Operador Resta */
( "-" ) {return createSymbol(sym.Resta, yytext());}

/* Operador Multiplicacion */
( "*" ) {return createSymbol(sym.Multiplicacion, yytext());}

/* Operador Division */
( "/" ) {return createSymbol(sym.Division, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return createSymbol(sym.Op_logico, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return createSymbol(sym.Op_relacional, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return createSymbol(sym.Op_atribucion, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return createSymbol(sym.Op_incremento, yytext());}

/*Operadores Booleanos*/
( true | false ) {return createSymbol(sym.Op_booleano, yytext());}

/* Parentesis de apertura */
( "(" ) {return createSymbol(sym.Parentesis_a, yytext());}

/* Parentesis de cierre */
( ")" ) {return createSymbol(sym.Parentesis_c, yytext());}

/* Llave de apertura */
( "{" ) {return createSymbol(sym.Llave_a, yytext());}

/* Llave de cierre */
( "}" ) {return createSymbol(sym.Llave_c, yytext());}

/* Corchete de apertura */
( "[" ) {return createSymbol(sym.Corchete_a, yytext());}

/* Corchete de cierre */
( "]" ) {return createSymbol(sym.Corchete_c, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return createSymbol(sym.Main, yytext());}

/* Punto y coma */
( ";" ) {return createSymbol(sym.P_coma, yytext());}

/* Identificador */
{L}({L}|{D})* {return createSymbol(sym.Identificador, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return createSymbol(sym.Numero, yytext());}

/* Error de analisis */
 . {return createSymbol(sym.ERROR, yytext());}
