package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import com.calculadora.domain.services.contracts.OperacionUnaria;
import com.calculadora.domain.services.contracts.ValidableUnaria;

public class LogaritmoNatural implements OperacionUnaria, ValidableUnaria {
    @Override
    public boolean esValido(Numero a) {
        return a.getValor() > 0;
    }

    @Override
    public double ejecutar(Numero a) {
        if (!esValido(a)) {
            throw new IllegalArgumentException("Violación de precondición: Logaritmo natural de menor o igual a cero no es válido.");
        }
        return Math.log(a.getValor());
    }
}
