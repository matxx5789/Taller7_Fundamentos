package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import com.calculadora.domain.services.contracts.OperacionBinaria;

public class Resta implements OperacionBinaria {
    @Override
    public double ejecutar(Numero a, Numero b) {
        return a.getValor() - b.getValor();
    }
}
