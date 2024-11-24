package codigo.lexer;
import static codigo.lexer.TokenType.*;
%%

%class Lexer
%type Token
%line
%unicode
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
    public int line;
%}


%%

/* Reglas de tokens */
/* Espacios en blanco */
{espacio} { /* Ignore */ }

/* Comentarios de línea */
"//"([^\n])* { /* Ignore */ }

/* Comentarios de bloque */
"/*"([^*]|"*"+[^/*])*"*"+"/" { /* Ignore */ }

/* Comentario sin terminar */
"/*" { /* Agregar manejo de error para comentario sin terminar */ return new Token(INVALID_TOKEN, "Unclosed comment", yyline); }

/* Salto de línea */
"\n" { return new Token(Linea, "\\n", yyline); }

/* Comillas */
"\"" { lexeme = yytext(); return new Token(Comillas, lexeme, yyline); }

/* Tipos de datos */
(byte | int | char | long | float | double) { lexeme = yytext(); return new Token(T_dato, lexeme, yyline); }
(String) { lexeme = yytext(); return new Token(Cadena, lexeme, yyline); }

/* Palabras reservadas */
(if) { lexeme = yytext(); return new Token(If, lexeme, yyline); }
(else) { lexeme = yytext(); return new Token(Else, lexeme, yyline); }
(do) { lexeme = yytext(); return new Token(Do, lexeme, yyline); }
(while) { lexeme = yytext(); return new Token(While, lexeme, yyline); }
(for) { lexeme = yytext(); return new Token(For, lexeme, yyline); }
(main) { lexeme = yytext(); return new Token(Main, lexeme, yyline); }
(return) { lexeme = yytext(); return new Token(Return, lexeme, yyline); }

/* Operadores */
("=") { lexeme = yytext(); return new Token(Igual, lexeme, yyline); }
("+" | "-") { lexeme = yytext(); return new Token(Suma, lexeme, yyline); }
("*" | "/") { lexeme = yytext(); return new Token(Multiplicacion, lexeme, yyline); }
("++" | "--") { lexeme = yytext(); return new Token(Op_incremento, lexeme, yyline); }

/* Operadores Lógicos */
("&&" | "||" | "!") { lexeme = yytext(); return new Token(Op_logico, lexeme, yyline); }

/* Operadores Relacionales */
(">" | "<" | "==" | "!=" | ">=" | "<=") { lexeme = yytext(); return new Token(Op_relacional, lexeme, yyline); }

/* Operadores de Atribución */
("+=" | "-=" | "*=" | "/=" | "%=") { lexeme = yytext(); return new Token(Op_atribucion, lexeme, yyline); }

/* Paréntesis, Llaves y Corchetes */
("(") { lexeme = yytext(); return new Token(Parentesis_a, lexeme, yyline); }
(")") { lexeme = yytext(); return new Token(Parentesis_c, lexeme, yyline); }
("{" ) { lexeme = yytext(); return new Token(Llave_a, lexeme, yyline); }
("}") { lexeme = yytext(); return new Token(Llave_c, lexeme, yyline); }
("[" ) { lexeme = yytext(); return new Token(Corchete_a, lexeme, yyline); }
("]") { lexeme = yytext(); return new Token(Corchete_c, lexeme, yyline); }

/* Identificadores */
{L}({L}|{D})* { lexeme = yytext(); return new Token(Identificador, lexeme, yyline); }

/* Números */
("0x"[0-9a-fA-F]+) { lexeme = yytext(); return new Token(Numero_hex, lexeme, yyline); }
("0"[0-7]+) { lexeme = yytext(); return new Token(Numero_oct, lexeme, yyline); }
({D}+"."{D}+[eE][-+]?{D}+) { lexeme = yytext(); return new Token(Numero_cientifico, lexeme, yyline); }
({D}+ ) { lexeme = yytext(); return new Token(Numero, lexeme, yyline); }

/* Error de análisis */
. { return new Token(INVALID_TOKEN, yytext(), yyline); }
