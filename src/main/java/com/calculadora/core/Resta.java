package com.calculadora.core;

public class Resta extends OperacionBinaria {
    @Override
    public double ejecutar(int a, int b) {
        return a - b;
    }
}
