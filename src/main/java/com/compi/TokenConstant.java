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
    XOR_BINARIO,
    MODULO,
    DESPLAZAMIENTO_IZQ,
    DESPLAZAMIENTO_DER,
    ASIGNACION_ADITIVA,
    ASIGNACION_SUSTRACTIVA,
    ASIGNACION_MULTIPLICATIVA,
    ASIGNACION_DIVISIVA,
    ASIGNACION_MODULO,
    AND_LOGICO,
    OR_LOGICO,
    NOT_LOGICO,
    COMPLEMENTO_BINARIO,

    // Otros
    ID,
    NUM,
    NUM_HEX,
    STRING,
    CHAR_LITERAL,
    EOF,
    NEWLINE,
    ERROR,
    NUM_CIENTIFICO,
}