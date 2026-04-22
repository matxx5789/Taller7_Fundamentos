package com.calculadora.core;

public class RaizCuadrada extends OperacionUnaria {
    @Override
    public double ejecutar(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }
}
