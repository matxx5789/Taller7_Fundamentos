package com.calculadora.core;

public class LogaritmoNatural extends OperacionUnaria {
    @Override
    public double ejecutar(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(a);
    }
}
