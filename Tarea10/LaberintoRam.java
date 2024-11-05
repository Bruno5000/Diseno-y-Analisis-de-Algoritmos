import java.util.*;

public class LaberintoRam {

    // Coordenadas de movimiento: arriba, abajo, izquierda, derecha
    private static final int[][] DIRECCIONES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Calcula la distancia Manhattan entre dos puntos
    public static int distanciaManhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Resuelve el laberinto usando BFS con Ramificación y Poda basada en la distancia Manhattan
    public static int resolverLaberinto(char[][] laberinto, int[] inicio, int[] salida) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristica));
        colaPrioridad.add(new Nodo(inicio[0], inicio[1], 0, distanciaManhattan(inicio[0], inicio[1], salida[0], salida[1]), new ArrayList<>()));

        Set<String> visitados = new HashSet<>();
        visitados.add(inicio[0] + "," + inicio[1]);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodo = colaPrioridad.poll();
            int x = nodo.x;
            int y = nodo.y;
            int pasos = nodo.pasos;
            List<int[]> camino = nodo.camino;
            camino.add(new int[]{x, y});

            System.out.println("Visitando: (" + x + ", " + y + "), Pasos: " + pasos + ", Heurística: " + nodo.heuristica);

            // Si llegamos a la salida, devolvemos el número de pasos y mostramos el camino
            if (x == salida[0] && y == salida[1]) {
                System.out.println("Camino encontrado:");
                for (int[] paso : camino) {
                    System.out.print(Arrays.toString(paso) + " ");
                }
                System.out.println();
                return pasos;
            }

            // Explora los movimientos posibles
            for (int[] dir : DIRECCIONES) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Verifica que el movimiento esté dentro del laberinto y sea una celda accesible
                if (nx >= 0 && ny >= 0 && nx < laberinto.length && ny < laberinto[0].length && (laberinto[nx][ny] == 'c' || laberinto[nx][ny] == 's')) {
                    String pos = nx + "," + ny;
                    if (!visitados.contains(pos)) {
                        visitados.add(pos);
                        int nuevaHeuristica = pasos + 1 + distanciaManhattan(nx, ny, salida[0], salida[1]);
                        List<int[]> nuevoCamino = new ArrayList<>(camino);
                        colaPrioridad.add(new Nodo(nx, ny, pasos + 1, nuevaHeuristica, nuevoCamino));
                    }
                }
            }
        }

        System.out.println("No se encontró un camino hasta la salida.");
        return -1;
    }

    // Clase interna Nodo para almacenar la información de cada posición en la cola de prioridad
    static class Nodo {
        int x, y, pasos, heuristica;
        List<int[]> camino;

        Nodo(int x, int y, int pasos, int heuristica, List<int[]> camino) {
            this.x = x;
            this.y = y;
            this.pasos = pasos;
            this.heuristica = heuristica;
            this.camino = camino;
        }
    }

    public static void main(String[] args) {
        char[][] laberinto = {
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'c', 'p', 'c', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'p', 'c', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'p', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'c', 'p', 'c', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'p', 'c', 'p'},
            {'p', 'p', 'p', 'p', 'c', 'c', 'c', 's'},
            {'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'p', 'p'},
            {'p', 'p', 'c', 'p', 'p', 'c', 'p', 'p'},
            {'p', 'p', 'E', 'p', 'p', 'p', 'p', 'p'}
        };

        int[] inicio = {13, 2}; // Posición de entrada
        int[] salida = {9, 7};  // Posición de salida

        int pasos = resolverLaberinto(laberinto, inicio, salida);
        if (pasos != -1) {
            System.out.println("Se encontró un camino hasta la salida en " + pasos + " pasos.");
        } else {
            System.out.println("No se encontró un camino hasta la salida.");
        }
    }
}
