public class CombinacionesPares {
    public static void generarCombinaciones(int[] arr) {
        int totalCombinaciones = 0;

        System.out.print("Entrada: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Generar todas las combinaciones de pares
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
                totalCombinaciones++;
            }
        }

        System.out.println("Final: " + totalCombinaciones);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generarCombinaciones(arr);
    }

    /*
    Complejidad T(n):
    - El bucle para imprimir la entrada tiene una complejidad de O(n).
    - El bucle doble para generar las combinaciones tiene una complejidad de O(n^2).
    - No hay otros bucles ni operaciones significativas fuera de estos.

    En resumen, la complejidad total del programa es O(n^2), donde n es la longitud del arreglo.
    */
}
