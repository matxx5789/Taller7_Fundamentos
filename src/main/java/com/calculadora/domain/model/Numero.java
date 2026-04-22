package com.calculadora.domain.model;

import java.util.Objects;

/**
 * Value Object en DDD que encapsula la noción de un número dentro de nuestro dominio matemático.
 * Asegura la inmutabilidad de los datos.
 */
public final class Numero {
    private final int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numero numero = (Numero) o;
        return valor == numero.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
