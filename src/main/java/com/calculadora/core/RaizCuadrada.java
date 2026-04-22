package com.calculadora.core;

public class RaizCuadrada extends OperacionUnaria {
    @Override
    public boolean esValido(int a) {
        return a >= 0;
    }

    @Override
    public double ejecutar(int a) {
        if (!esValido(a)) {
            throw new IllegalArgumentException("Violación de precondición: No existe raíz cuadrada real para número negativo.");
        }
        return Math.sqrt(a);
    }
}
