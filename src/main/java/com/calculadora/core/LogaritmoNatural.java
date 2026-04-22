package com.calculadora.core;

public class LogaritmoNatural implements OperacionUnaria, ValidableUnaria {
    @Override
    public boolean esValido(int a) {
        return a > 0;
    }

    @Override
    public double ejecutar(int a) {
        if (!esValido(a)) {
            throw new IllegalArgumentException("Violación de precondición: Logaritmo natural de menor o igual a cero no es válido.");
        }
        return Math.log(a);
    }
}
