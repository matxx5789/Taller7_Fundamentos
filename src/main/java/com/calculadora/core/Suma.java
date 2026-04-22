package com.calculadora.core;

public class Suma extends OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        return a + b;
    }
}
