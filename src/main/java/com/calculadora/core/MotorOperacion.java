package com.calculadora.core;

import java.util.Scanner;
import com.calculadora.utils.Validacion;

public class MotorOperacion {
    public void ejecutarOpcion(int opcion, Scanner scanner) {
        try {
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer entero: ");
                int num1 = Validacion.leerEntero(scanner);
                System.out.print("Ingrese el segundo entero: ");
                int num2 = Validacion.leerEntero(scanner);

                OperacionBinaria operacion = null;
                switch (opcion) {
                    case 1: operacion = new Suma(); break;
                    case 2: operacion = new Resta(); break;
                    case 3: operacion = new Multiplicacion(); break;
                    case 4: operacion = new Division(); break;
                }
                
                if (operacion != null) {
                    System.out.println("Resultado: " + operacion.ejecutar(num1, num2));
                }
            } else if (opcion == 5 || opcion == 6) {
                System.out.print("Ingrese un entero: ");
                int num = Validacion.leerEntero(scanner);

                OperacionUnaria operacion = null;
                switch (opcion) {
                    case 5: operacion = new RaizCuadrada(); break;
                    case 6: operacion = new LogaritmoNatural(); break;
                }
                
                if (operacion != null) {
                    System.out.println("Resultado: " + operacion.ejecutar(num));
                }
            } else {
                if (opcion != -1) {
                    System.out.println("Opción no válida.");
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                }
            }
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
