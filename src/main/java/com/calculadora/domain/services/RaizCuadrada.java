package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import com.calculadora.domain.services.contracts.OperacionUnaria;
import com.calculadora.domain.services.contracts.ValidableUnaria;

public class RaizCuadrada implements OperacionUnaria, ValidableUnaria {
    @Override
    public boolean esValido(Numero a) {
        return a.getValor() >= 0;
    }

    @Override
    public double ejecutar(Numero a) {
        if (!esValido(a)) {
            throw new IllegalArgumentException("Violación de precondición: No existe raíz cuadrada real para número negativo.");
        }
        return Math.sqrt(a.getValor());
    }
}
