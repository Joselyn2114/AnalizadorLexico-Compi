// ** Archivo de especificación léxica **
//Parte 1 : CODIGO COPIADO INTEGRO

package com.compi;//Declara el paquete donde quiero generar mi clase

%%
//Parte 2 : OPCIONES Y DECLARACIONES
%public
%class DemoLexer

//Macros con expresiones regulares para usar en reglas
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r]
newline = [\n]

%type Token

%eofval{ //Macro cuando se encuentre el final de una cadena

     return new Token(TokenConstant.EOF, null);

%eofval}
%%
//Parte 3: REGLAS LÉXICAS

//se establecen con expresiones regulares
{letter}({letter}|{digit})* { return new Token(TokenConstant.ID, yytext()); }//yytext retorna el texto que hizo concidencia con la expresion regular.
{digit}+ { return new Token(TokenConstant.NUM, yytext());  }
{whitespace}+ { /* ignore */}
{newline} { return new Token(TokenConstant.NEWLINE, yytext()); }
[^] {return new Token(TokenConstant.ERROR, yytext());}//Para cuando no pueda reconocer una cadena