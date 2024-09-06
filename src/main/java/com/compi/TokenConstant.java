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