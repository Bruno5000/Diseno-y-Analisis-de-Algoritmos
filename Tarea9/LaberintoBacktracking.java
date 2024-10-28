public class LaberintoBacktracking {

    // Definir el laberinto
    static char[][] laberinto = {
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'c', 'c', 'c', 'p', 'p', 'p'},
        {'p', 'p', 'c', 'c', 'c', 'c', 'c', 'p'},
        {'p', 'p', 'c', 'p', 'p', 'c', 'p', 'p'},
        {'p', 'p', 'c', 'c', 'p', 'c', 's', 'p'},
        {'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'X', 'c', 'p', 'p', 'p', 'p'},
        {'p', 'X', 'c', 'c', 'c', 'p', 'p', 'p'},
        {'p', 'p', 'c', 'p', 'p', 'p', 'p', 'p'},
        {'p', 'p', 'E', 'p', 'p', 'p', 'p', 'p'}
    };

    // Posiciones de movimiento (arriba, abajo, izquierda, derecha)
    static int[][] movimientos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Coordenadas iniciales (posición de E)
    static int inicioX = 13;
    static int inicioY = 2;

    public static void main(String[] args) {
        if (resolverLaberinto(inicioX, inicioY)) {
            System.out.println("Se encontró una solución:");
            imprimirLaberinto();
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Método principal de backtracking
    public static boolean resolverLaberinto(int x, int y) {
        // Si hemos llegado a la salida, retornar verdadero
        if (laberinto[x][y] == 's') {
            return true;
        }

        // Marcar la posición actual como visitada
        laberinto[x][y] = 'X';

        // Intentar moverse en cada dirección
        for (int[] mov : movimientos) {
            int nuevoX = x + mov[0];
            int nuevoY = y + mov[1];

            // Verificar si el movimiento es válido
            if (esValido(nuevoX, nuevoY)) {
                // Llamada recursiva
                if (resolverLaberinto(nuevoX, nuevoY)) {
                    return true;
                }
            }
        }

        // Desmarcar la posición actual si no es parte de la solución (retroceder)
        laberinto[x][y] = 'c';
        return false;
    }

    // Verificar si una posición es válida para moverse
    public static boolean esValido(int x, int y) {
        return x >= 0 && x < laberinto.length &&
               y >= 0 && y < laberinto[0].length &&
               (laberinto[x][y] == 'c' || laberinto[x][y] == 's');
    }

    // Imprimir el laberinto después de encontrar la solución
    public static void imprimirLaberinto() {
        for (char[] fila : laberinto) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}
