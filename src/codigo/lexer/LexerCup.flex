package codigo;
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
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Palabra reservada Return */
 "return" {return new Symbol(sym.Return, yychar, yyline, yytext());}

/* Tipos de datos */
( byte | char | long | float | double ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

/* Tipo de dato Int (Para el main) */
( "int" ) {return new Symbol(sym.Int, yychar, yyline, yytext());}

/* Tipo de dato String */
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.While, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

// AGREGANDO NUEVOS SYMBOL

/* Palabras reservadas adicionales */
(  const | unsigned | auto | break | case | continue | default | enum | extern | goto | register | short | signed | sizeof | static | struct | switch | typedef | union | void | volatile ) 
    { return new Symbol(sym.Reservada, yychar, yyline, yytext()); }

/* Operadores binarios */
( "&" | "|" | "^" | "~" ) 
    { return new Symbol(sym.Op_binario, yychar, yyline, yytext()); }

/* Operadores de asignación compuesta */
( "+=" | "-=" | "*=" | "/=" | "%=" ) 
    { return new Symbol(sym.Op_atribucion, yychar, yyline, yytext()); }

/* Complemento binario */
( "~" ) 
    { return new Symbol(sym.Complemento_binario, yychar, yyline, yytext()); }

/* Punto y coma */
( ";" ) 
    { return new Symbol(sym.P_coma, yychar, yyline, yytext()); }

/* Literales */

/* Hexadecimales */
( "0x"[0-9a-fA-F]+ ) 
    { return new Symbol(sym.Numero_hex, yychar, yyline, yytext()); }

/* Octales */
( "0"[0-7]+ ) 
    { return new Symbol(sym.Numero_oct, yychar, yyline, yytext()); }

/* Números en notación científica */
( {D}+"."{D}+[eE][-+]?{D}+ ) 
    { return new Symbol(sym.Numero_cientifico, yychar, yyline, yytext()); }

/* Otros símbolos */

/* Dos puntos */
( ":" ) 
    { return new Symbol(sym.Dos_puntos, yychar, yyline, yytext()); }

/* Nueva línea */
( "\n" ) 
    { return new Symbol(sym.Nueva_linea, yychar, yyline, yytext()); }

/* Manejo de comentarios */

/* Comentarios de bloque */
"/*"([^*]|"*"+[^/*])*"*"+"/" 
    { /* Ignore block comment */ }

/* Comentario sin terminar */
"/*" 
    { /* Error handling for unterminated comment */ return new Symbol(sym.ERROR, yychar, yyline, "Unterminated comment"); }


/*REGLA FINAL*/
/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
