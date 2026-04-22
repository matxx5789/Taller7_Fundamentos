package com.calculadora.core;

public abstract class OperacionUnaria {
    /**
     * Valida si la operación puede llevarse a cabo con el dato dado.
     * Por defecto todas las operaciones son válidas.
     */
    public boolean esValido(int a) {
        return true;
    }

    public abstract double ejecutar(int a);
}
