package com.calculadora.core;

public class Multiplicacion implements OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        return a * b;
    }
}
