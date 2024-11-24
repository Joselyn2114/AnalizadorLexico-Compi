/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.lexer;

/**
 *
 * @author Charly Ponce
 */
public enum TokenType  {
    Linea,
    Comillas,
    T_dato,
    Cadena,
    If,
    Else,
    Do,
    While,
    For,
    Igual,
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Op_logico,
    Op_incremento,
    Op_relacional,
    Op_atribucion,
    Op_booleano,
    Parentesis_a,
    Parentesis_c,
    Llave_a,
    Llave_c,
    Corchete_a,
    Corchete_c,
    Main,
    P_coma,
    Identificador,
    Numero,
    ERROR,
    Void,
    Numero_hex,
    Numero_oct,
    Numero_cientifico,
    Complemento_binario,
    Dos_puntos,
    Nueva_linea,
    Reservada,
    Op_binario,
    Const,
    Return,
    IDENTIFIER,
    NUMBER,
    STRING,
    OPERATOR,
    KEYWORD,
    VARIABLE_DECLARATION,
    USE_VARIABLE,
    BREAK_STATEMENT,
    CONTINUE_STATEMENT,
    INVALID_TOKEN
}


