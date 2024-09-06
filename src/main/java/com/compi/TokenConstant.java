package com.compi;

public enum TokenConstant {
    // Palabras reservadas
    INT,
    FLOAT,
    CHAR,
    UNSIGNED,
    CONST,
    DOUBLE,
    IF,
    WHILE,
    RETURN,
    AUTO,
    BREAK,
    CASE,
    CONTINUE,
    DEFAULT,
    DO,
    ELSE,
    ENUM,
    EXTERN,
    FOR,
    GOTO,
    LONG,
    REGISTER,
    SHORT,
    SIGNED,
    SIZEOF,
    STATIC,
    STRUCT,
    SWITCH,
    TYPEDEF,
    UNION,
    VOID,
    VOLATILE,

    // Operadores y delimitadores
    IGUALDAD,            // "=="
    NO_IGUAL,            // "!="
    ADITIVO,             // "+"
    SUSTRACTIVO,         // "-"
    MULTIPLICACION,      // "*"
    DIVISION,            // "/"
    ASIGNACION,          // "="
    PARENTESIS_IZQ,      // "("
    PARENTESIS_DER,      // ")"
    LLAVE_IZQ,           // "{"
    LLAVE_DER,           // "}"
    PUNTO_Y_COMA,        // ";"
    COMA,                // ","
    INCREMENTO,
    DECREMENTO,
    MAYOR_IGUAL,
    MENOR_IGUAL,
    MAYOR,
    MENOR,
    AND_BINARIO,
    OR_BINARIO,

    // Otros
    ID,
    NUM,
    STRING,
    CHAR_LITERAL,
    EOF,
    NEWLINE,
    ERROR,
    NUM_CIENTIFICO,
}