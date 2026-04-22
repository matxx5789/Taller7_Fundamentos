package com.calculadora.core;

public class Division extends OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return (double) a / b;
    }
}
