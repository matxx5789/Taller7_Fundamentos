package com.calculadora.domain.services.contracts;

import com.calculadora.domain.model.Numero;

public interface OperacionUnaria {
    double ejecutar(Numero a);
}
