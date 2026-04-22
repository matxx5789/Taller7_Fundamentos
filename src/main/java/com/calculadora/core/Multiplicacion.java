package com.calculadora.core;

public class Multiplicacion extends OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        return a * b;
    }
}
