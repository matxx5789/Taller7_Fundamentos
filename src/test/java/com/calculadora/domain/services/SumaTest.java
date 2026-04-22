package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumaTest {
    @Test
    public void deberiaSumarDosNumeros() {
        Suma suma = new Suma();
        Numero a = new Numero(5);
        Numero b = new Numero(3);
        double resultado = suma.ejecutar(a, b);
        assertEquals(8.0, resultado, "5 + 3 debería ser 8.0");
    }
}
