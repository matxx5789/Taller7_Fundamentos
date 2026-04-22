package com.calculadora.ui;

import com.calculadora.application.CalculadoraApplicationService;
import com.calculadora.utils.Validacion;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final CalculadoraApplicationService appService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.appService = new CalculadoraApplicationService();
    }

    public void iniciar() {
        boolean continuar = true;
        System.out.println("--- Calculadora DDD/TDD ---");

        while (continuar) {
            mostrarOpciones();
            int opcion = Validacion.leerOpcion(scanner);

            if (opcion == 7) {
                continuar = false;
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer entero: ");
                int num1 = Validacion.leerEntero(scanner);
                System.out.print("Ingrese el segundo entero: ");
                int num2 = Validacion.leerEntero(scanner);
                appService.procesarOperacionBinaria(opcion, num1, num2);
            } else if (opcion == 5 || opcion == 6) {
                System.out.print("Ingrese un entero: ");
                int num = Validacion.leerEntero(scanner);
                appService.procesarOperacionUnaria(opcion, num);
            } else {
                if (opcion != -1) {
                    System.out.println("Opción no válida.");
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                }
            }
        }
        scanner.close();
    }

    private void mostrarOpciones() {
        System.out.println("\nSeleccione una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Raíz Cuadrada");
        System.out.println("6. Logaritmo Natural");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }
}
