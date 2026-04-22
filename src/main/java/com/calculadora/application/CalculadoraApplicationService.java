package com.calculadora.application;

import com.calculadora.domain.model.Numero;
import com.calculadora.domain.services.*;
import com.calculadora.domain.services.contracts.OperacionBinaria;
import com.calculadora.domain.services.contracts.OperacionUnaria;
import com.calculadora.domain.services.contracts.ValidableBinaria;
import com.calculadora.domain.services.contracts.ValidableUnaria;

public class CalculadoraApplicationService {

    public void procesarOperacionBinaria(int opcion, int num1, int num2) {
        Numero n1 = new Numero(num1);
        Numero n2 = new Numero(num2);

        OperacionBinaria operacion = null;
        switch (opcion) {
            case 1: operacion = new Suma(); break;
            case 2: operacion = new Resta(); break;
            case 3: operacion = new Multiplicacion(); break;
            case 4: operacion = new Division(); break;
        }

        if (operacion != null) {
            boolean operacionValida = true;
            if (operacion instanceof ValidableBinaria) {
                operacionValida = ((ValidableBinaria) operacion).esValido(n1, n2);
            }

            if (operacionValida) {
                System.out.println("Resultado: " + operacion.ejecutar(n1, n2));
            } else {
                System.out.println("Error: Los números dados no son válidos para esta operación.");
            }
        }
    }

    public void procesarOperacionUnaria(int opcion, int num) {
        Numero n = new Numero(num);

        OperacionUnaria operacion = null;
        switch (opcion) {
            case 5: operacion = new RaizCuadrada(); break;
            case 6: operacion = new LogaritmoNatural(); break;
        }

        if (operacion != null) {
            boolean operacionValida = true;
            if (operacion instanceof ValidableUnaria) {
                operacionValida = ((ValidableUnaria) operacion).esValido(n);
            }

            if (operacionValida) {
                System.out.println("Resultado: " + operacion.ejecutar(n));
            } else {
                System.out.println("Error: El número dado no es válido para esta operación.");
            }
        }
    }
}
