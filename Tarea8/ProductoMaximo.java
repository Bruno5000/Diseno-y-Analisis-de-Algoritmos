public class ProductoMaximo {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        // Encontrar el producto máximo en el arreglo
        int resultado = productoMaximo(arr, 0, arr.length - 1);
        // Calcular el producto cruzado 
        int mid = (0 + arr.length - 1) / 2;  // Calcula el punto medio
        int resultado1 = productoMaximoCruzado(arr, 0, mid, arr.length - 1);

        // Imprimir los resultados
        System.out.println("El producto máximo es: " + resultado);
        System.out.println("El producto máximo cruzado es: " + resultado1);
    }

    // Función principal para encontrar el producto máximo en el arreglo
    public static int productoMaximo(int[] arr, int inicio, int fin) {
        // Caso base: si el subarreglo tiene un solo elemento
        if (inicio == fin) {
            return arr[inicio];
        }

        // Encontrar el punto medio del arreglo
        int mid = (inicio + fin) / 2;

        // Calcular el producto máximo en la mitad izquierda
        int productoIzquierda = productoMaximo(arr, inicio, mid);

        // Calcular el producto máximo en la mitad derecha
        int productoDerecha = productoMaximo(arr, mid + 1, fin);

        // Calcular el producto máximo cruzado
        int productoCruzado = productoMaximoCruzado(arr, inicio, mid, fin);

        // Retornar el máximo entre las tres opciones
        return Math.max(Math.max(productoIzquierda, productoDerecha), productoCruzado);
    }

    // Función para calcular el producto máximo cruzado que incluye elementos de ambas mitades
    public static int productoMaximoCruzado(int[] arr, int inicio, int mid, int fin) {
        // Producto hacia la izquierda desde el punto medio
        int productoIzquierda = arr[mid];
        int maxIzquierda = arr[mid];
        int productoTemp = arr[mid];

        for (int i = mid - 1; i >= inicio; i--) {
            productoTemp *= arr[i];
            maxIzquierda = Math.max(maxIzquierda, productoTemp);
        }

        // Producto hacia la derecha desde el punto medio
        int productoDerecha = arr[mid + 1];
        int maxDerecha = arr[mid + 1];
        productoTemp = arr[mid + 1];

        for (int i = mid + 2; i <= fin; i++) {
            productoTemp *= arr[i];
            maxDerecha = Math.max(maxDerecha, productoTemp);
        }

        // El producto cruzado será el producto máximo de ambos lados
        return maxIzquierda * maxDerecha;
    }
}
