package com.calculadora.domain.services;

import com.calculadora.domain.model.Numero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {
    @Test
    public void deberiaDividirDosNumerosValidos() {
        Division division = new Division();
        Numero a = new Numero(10);
        Numero b = new Numero(2);
        
        assertTrue(division.esValido(a, b), "La división debería ser válida si b no es cero");
        assertEquals(5.0, division.ejecutar(a, b), "10 / 2 debería ser 5.0");
    }

    @Test
    public void deberiaValidarDivisionPorCeroComoFalsa() {
        Division division = new Division();
        Numero a = new Numero(5);
        Numero b = new Numero(0);
        
        assertFalse(division.esValido(a, b), "La división debería ser inválida si b es cero");
        
        assertThrows(IllegalArgumentException.class, () -> {
            division.ejecutar(a, b);
        }, "Debería lanzar IllegalArgumentException si se intenta dividir por cero ignorando la precondición");
    }
}
