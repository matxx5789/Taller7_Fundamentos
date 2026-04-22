package com.calculadora.domain.services.contracts;

import com.calculadora.domain.model.Numero;

public interface OperacionBinaria {
    double ejecutar(Numero a, Numero b);
}
