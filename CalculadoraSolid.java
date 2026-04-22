import java.util.Scanner;

public class CalculadoraSolid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("--- Calculadora ---");

        while (continuar) {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Raíz Cuadrada");
            System.out.println("6. Logaritmo Natural");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                continue;
            }

            if (opcion == 7) {
                continuar = false;
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer entero: ");
                int num1 = leerEntero(scanner);
                System.out.print("Ingrese el segundo entero: ");
                int num2 = leerEntero(scanner);

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + multiplicar(num1, num2));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado: " + dividir(num1, num2));
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                }
            } else if (opcion == 5 || opcion == 6) {
                System.out.print("Ingrese un entero: ");
                int num = leerEntero(scanner);

                switch (opcion) {
                    case 5:
                        try {
                            System.out.println("Resultado: " + raizCuadrada(num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("Resultado: " + logaritmoNatural(num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida, se esperaba un número entero. Intente de nuevo: ");
            }
        }
    }

    // --- Operaciones Binarias ---
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return (double) a / b;
    }

    // --- Operaciones Unarias ---
    public static double raizCuadrada(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    public static double logaritmoNatural(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números mayores que cero.");
        }
        return Math.log(a);
    }
}
