package com.calculadora.domain.services.contracts;

import com.calculadora.domain.model.Numero;

public interface ValidableBinaria {
    boolean esValido(Numero a, Numero b);
}
