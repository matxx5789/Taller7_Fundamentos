package com.calculadora.core;

import java.util.Scanner;
import com.calculadora.utils.Validacion;

public class MotorOperacion {
    private final Operacion operacion;

    public MotorOperacion() {
        this.operacion = new Operacion();
    }

    public void ejecutarOpcion(int opcion, Scanner scanner) {
        try {
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer entero: ");
                int num1 = Validacion.leerEntero(scanner);
                System.out.print("Ingrese el segundo entero: ");
                int num2 = Validacion.leerEntero(scanner);

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + operacion.sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + operacion.restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + operacion.multiplicar(num1, num2));
                        break;
                    case 4:
                        System.out.println("Resultado: " + operacion.dividir(num1, num2));
                        break;
                }
            } else if (opcion == 5 || opcion == 6) {
                System.out.print("Ingrese un entero: ");
                int num = Validacion.leerEntero(scanner);

                switch (opcion) {
                    case 5:
                        System.out.println("Resultado: " + operacion.raizCuadrada(num));
                        break;
                    case 6:
                        System.out.println("Resultado: " + operacion.logaritmoNatural(num));
                        break;
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
