package com.calculadora.core;

public class Division extends OperacionBinaria {
    @Override
    public boolean esValido(int a, int b) {
        return b != 0;
    }

    @Override
    public double ejecutar(int a, int b) {
        if (!esValido(a, b)) {
            throw new IllegalArgumentException("Violación de precondición: No se puede dividir por cero.");
        }
        return (double) a / b;
    }
}
