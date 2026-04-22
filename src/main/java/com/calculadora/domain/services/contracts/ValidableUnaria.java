package com.calculadora.domain.services.contracts;

import com.calculadora.domain.model.Numero;

public interface ValidableUnaria {
    boolean esValido(Numero a);
}
