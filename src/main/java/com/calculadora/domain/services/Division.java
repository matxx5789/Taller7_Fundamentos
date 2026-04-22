package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import com.calculadora.domain.services.contracts.OperacionBinaria;
import com.calculadora.domain.services.contracts.ValidableBinaria;

public class Division implements OperacionBinaria, ValidableBinaria {
    @Override
    public boolean esValido(Numero a, Numero b) {
        return b.getValor() != 0;
    }

    @Override
    public double ejecutar(Numero a, Numero b) {
        if (!esValido(a, b)) {
            throw new IllegalArgumentException("Violación de precondición: No se puede dividir por cero.");
        }
        return (double) a.getValor() / b.getValor();
    }
}
