# Análisis Estructural de la Calculadora Inicial

A continuación, se presentan las respuestas correspondientes al análisis del archivo monolítico inicial previo a la refactorización (el "code smell" inicial del proyecto).

### 01. ¿Qué responsabilidades tiene exactamente esta clase?
Esa clase original era un "God Object" (Objeto Dios) y violaba por completo el Principio de Responsabilidad Única (SRP). Tenía responsabilidades de:
*   **Interfaz de Usuario (UI):** Dibujar los menús con `System.out.println()`.
*   **Gestor de Entradas:** Interactuar con la consola usando el `Scanner` y controlar bucles interactivos (`while(continuar)`).
*   **Parseador y Validador:** Convertir texto a número y cazar excepciones de escritura (`NumberFormatException`).
*   **Enrutador (Controlador):** Llenarse de inmensos `switch` e `if/else` para dirigir a la gente a donde debían ir.
*   **Cálculo Matemático (Dominio):** Efectuar la lógica matemática pura (suma, división, etc.) dentro de la misma estructura.

### 02. Si cambio la forma de imprimir en consola, ¿qué pasa con las operaciones?
Tus operaciones **estarían en enorme riesgo**. Al estar la lógica de impresión (los menús) mezclada en el mismo archivo y en el mismo método interactivo que las lecturas y las sentencias `switch` de los cálculos, realizar un cambio simple en la interfaz (como pasar de textos planos a una ventanilla gráfica o cambiar un ciclo iterativo) podría romper estrepitosamente la ejecución de la lectura o modificar líneas críticas de cálculo matemático. Un error en la vista mata a las matemáticas enteras.

### 03. Si quiero tener 2 menús distintos, ¿qué debería modificar?
Tendrías que entrar al caótico método interactivo (el `main()`) y comenzar a inyectar lógica de estado compleja. Por ejemplo, tendrías que hacer algo como: `if (menuModo == 1) { ...dibujar menu 1 } else { ... dibujar menu 2 }`. Modificando, arruinando la legibilidad y ensuciando aún más una clase gigantesca, lo que fomenta de forma irrefutable tener código duplicado o espagueti.

### 04. ¿Cómo adiciono operaciones nuevas (ej. Potencia)? ¿Rompe algo más?
Viola directamente el Principio Abierto/Cerrado (**OCP**). Para poder añadirla habrías estado obligado a **modificar intensamente el interior** de la base:
1. Buscar en el texto plano del menú y añadir `"7. Potencia"`.
2. Modificar el enorme `switch` central y añadirle un nuevo caso (ej: `case 7:`), pidiendo ahí los datos.
3. Crear el método de la operación estática dentro del mismo documento. 
Cualquier error de sintaxis allí terminaría afectando el código de la suma, resta y detendría todo el programa. 

### 05. ¿Qué pasa si ingreso validaciones de dominio (ej. no dividir por cero, no logaritmos negativos)? ¿Dónde irían en este desastre?
Irían incrustadas de forma horrible, ya sea ensuciando adicionalmente los inmensos casos del `switch` original o, en el mejor de los casos, a base de `if` puros esparcidos dentro de los métodos iniciales (como lo fue el `if(b==0) -> throw new ...`). 
Esto causaba que el propio despachador (el `switch` o el menú) tuviera que estar persiguiendo y adivinando qué tipo de excepción iba a lanzarse, mezclando tristes controles de excepciones matemáticas serias de lógica pura (Division By Zero) con vulgares validaciones de interfaz ("Escribiste una letra X"). Un coctel mortal para la mantenibilidad general de la arquitectura.
