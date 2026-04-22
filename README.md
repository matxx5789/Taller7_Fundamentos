# Calculadora SoLiD

Este proyecto aborda la implementación de una calculadora interactiva por consola en Java, orientada a demostrar cómo se manejan múltiples operaciones matemáticas y las responsabilidades del código.

## Análisis de la clase `CalculadoraSolid.java`

Originalmente, se construyó el programa en un único archivo (`CalculadoraSolid.java`). Al estar todo en una misma clase, esta asume **múltiples responsabilidades**, rompiendo con el enfoque ideal del desarrollo orientado a objetos:

1. **Gestión de la Interfaz de Usuario (UI):** La clase imprime los menús en la consola (`System.out.println`) y maneja directamente todo el aspecto visual y la interacción con quien la usa.
2. **Recepción y Validación de Datos:** Se encarga de capturar el texto ingresado a través del escáner (`Scanner`), intentar convertirlo a entero numérico y atrapar los errores tipo texto/caracteres inválidos (`NumberFormatException`).
3. **Control de Flujo de la Aplicación:** Mediante múltiples condicionales (`switch` y `if/else`), decide qué métodos llamar y qué bloques ejecutar.
4. **Lógica Matemática y de Negocios:** La clase contiene de forma explícita todos los métodos que realizan el cálculo real (sumar, restar, dividir, calcular raíces) y la validación de excepciones matemáticas (como división por cero o logaritmos negativos).

> [!CAUTION]
> Rompe el Principio de Responsabilidad Única (SRP)
> Al tener todas estas responsabilidades aglomeradas, la clase `CalculadoraSolid` tiene muchos motivos para cambiar. Si decides añadir nuevas operaciones trigonométricas, o si decides cambiar de consola a una ventana visual, siempre tendrías que abrir y modificar este mismo archivo.

---

## Solución en Paquetes (Refactorización S.O.L.I.D.)

Para resolver la sobrecarga de responsabilidades, el código dentro del directorio `src/com/calculadora/` aplica pautas para distribuir lógicamente cada tarea:

* **Arquitectura Orientada a Interfaces (`operations/`):** 
  Se declaran los "contratos" o interfaces (`OperacionBinaria`, `OperacionUnaria`) para que la calculadora no dependa del desarrollo de la operación en sí, sino de la abstracción.
* **Módulos de Operación Pura (`operations/binarias/` y `operations/unarias/`):** 
  Cada operación matemática tiene ahora *su propio archivo* (su propia clase). **Responsabilidad:** la clase `Suma`, por ejemplo, únicamente se encarga de saber cómo sumar.
* **Aislamiento de la Interfaz de Usuario (`ui/ConsolaUI.java`):** 
  **Responsabilidad:** Capturar teclas, leer opciones e imprimir salidas al cliente. Si más adelante se quiere cambiar la consola por otra pantalla, las operaciones matemáticas seguirán intactas e independientes.
* **Punto de Arranque (`Main.java`):** 
  **Responsabilidad:** Unir las piezas. Inicializa la interfaz y enciende la calculadora de manera limpia.
