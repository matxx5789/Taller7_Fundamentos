package com.calculadora.core;

public abstract class OperacionBinaria {
    /**
     * Valida si la operación puede llevarse a cabo con los datos dados.
     * Por defecto todas las operaciones son válidas.
     */
    public boolean esValido(int a, int b) {
        return true;
    }

    public abstract double ejecutar(int a, int b);
}
