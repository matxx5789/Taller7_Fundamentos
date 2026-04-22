package com.calculadora.ui;

import com.calculadora.core.MotorOperacion;
import com.calculadora.utils.Validacion;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final MotorOperacion motor;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.motor = new MotorOperacion();
    }

    public void iniciar() {
        boolean continuar = true;
        System.out.println("--- Calculadora ---");

        while (continuar) {
            mostrarOpciones();
            int opcion = Validacion.leerOpcion(scanner);

            if (opcion == 7) {
                continuar = false;
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            motor.ejecutarOpcion(opcion, scanner);
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
