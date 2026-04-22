package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaizCuadradaTest {

    @Test
    public void deberiaCalcularRaizDeNumeroValido() {
        RaizCuadrada raiz = new RaizCuadrada();
        Numero n = new Numero(16);
        assertTrue(raiz.esValido(n));
        assertEquals(4.0, raiz.ejecutar(n));
    }

    @Test
    public void deberiaInvalidarRaizDeNumeroNegativo() {
        RaizCuadrada raiz = new RaizCuadrada();
        Numero n = new Numero(-4);
        assertFalse(raiz.esValido(n));
        
        assertThrows(IllegalArgumentException.class, () -> {
            raiz.ejecutar(n);
        });
    }
}
