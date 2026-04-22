package com.calculadora.core;

public class Resta implements OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        return a - b;
    }
}
