/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo.Semantic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author XPC_DC
 */
public class SymbolTable {
    private final Map<String, SemanticSymbol> symbols = new HashMap<>();

    public void define(String name, SemanticSymbol symbol) throws SemanticException {
        if (symbols.containsKey(name)) {
            throw new SemanticException("Variable '" + name + "' ya está definida.", symbol.getLine());
        }
        symbols.put(name, symbol);
    }

    public SemanticSymbol lookup(String name) throws SemanticException {
        if (!symbols.containsKey(name)) {
            throw new SemanticException("Variable '" + name + "' no está definida.", -1); // Línea desconocida
        }
        return symbols.get(name);
    }

    public Collection<SemanticSymbol> getAllSymbols() {
        return symbols.values();
    }
}

