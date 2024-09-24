import java.util.Scanner;

class Alumno {
    String numCuenta; // Cambiado a String
    String nombre;
    int edad;
    String correo;
    String materia1, materia2, materia3, materia4, materia5; // Cinco materias como strings
    double promedio;

    public Alumno(String numCuenta, String nombre, int edad, String correo,
                  String materia1, String materia2, String materia3, String materia4, String materia5, double promedio) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
        this.materia4 = materia4;
        this.materia5 = materia5;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Número de cuenta: " + numCuenta + "\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Correo: " + correo + "\n" +
                "Materias: " + materia1 + ", " + materia2 + ", " + materia3 + ", " + materia4 + ", " + materia5 + "\n" +
                "Promedio: " + promedio;
    }
}

class Nodo {
    Alumno alumno;
    Nodo izquierda, derecha;

    public Nodo(Alumno alumno) {
        this.alumno = alumno;
        izquierda = derecha = null;
    }
}

class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Alumno alumno) {
        raiz = insertarRecursivo(raiz, alumno);
    }

    private Nodo insertarRecursivo(Nodo raiz, Alumno alumno) {
        if (raiz == null) {
            raiz = new Nodo(alumno);
            return raiz;
        }

        if (alumno.numCuenta.compareTo(raiz.alumno.numCuenta) < 0) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, alumno);
        } else if (alumno.numCuenta.compareTo(raiz.alumno.numCuenta) > 0) {
            raiz.derecha = insertarRecursivo(raiz.derecha, alumno);
        }

        return raiz;
    }

    public Alumno buscar(String numCuenta) {
        return buscarRecursivo(raiz, numCuenta);
    }

    private Alumno buscarRecursivo(Nodo raiz, String numCuenta) {
        if (raiz == null || raiz.alumno.numCuenta.equals(numCuenta)) {
            return (raiz != null) ? raiz.alumno : null;
        }

        if (numCuenta.compareTo(raiz.alumno.numCuenta) < 0) {
            return buscarRecursivo(raiz.izquierda, numCuenta);
        }

        return buscarRecursivo(raiz.derecha, numCuenta);
    }

    public void mostrarAlumno(String numCuenta) {
        Alumno alumno = buscar(numCuenta);
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("El alumno con número de cuenta " + numCuenta + " no fue encontrado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        System.out.println("¿Cuántos alumnos desea agregar?");
        int numAlumnos = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Ingrese los datos del alumno #" + (i + 1) + " en el siguiente formato:");
            System.out.println("Número de cuenta, Nombre, Edad, Correo, Materia1, Materia2, Materia3, Materia4, Materia5, Promedio");
            System.out.println("Ejemplo: 32031101, Juan Pérez, 21, juan.perez@ejemplo.com, Matemáticas, Física, Química, Historia, Inglés, 8.5");

            String entrada = scanner.nextLine();
            String[] partes = entrada.split(",\\s*");

            try {
                // Extraer los datos del formato
                String numCuenta = partes[0].trim();
                String nombre = partes[1].trim();
                int edad = Integer.parseInt(partes[2].trim());
                String correo = partes[3].trim();

                // Extraer las 5 materias como strings
                String materia1 = partes[4].trim();
                String materia2 = partes[5].trim();
                String materia3 = partes[6].trim();
                String materia4 = partes[7].trim();
                String materia5 = partes[8].trim();

                double promedio = Double.parseDouble(partes[9].trim());

                // Crear el objeto Alumno y añadirlo al árbol
                Alumno alumno = new Alumno(numCuenta, nombre, edad, correo, materia1, materia2, materia3, materia4, materia5, promedio);
                arbol.insertar(alumno);
                System.out.println("Alumno añadido al árbol.\n");
            } catch (NumberFormatException e) {
                System.out.println("Error en la entrada de datos: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Por favor, asegúrese de que la entrada tenga todos los campos requeridos.");
            }
        }

        // Permitir al usuario buscar un alumno por número de cuenta
        String opcion = "";
        while (!opcion.equalsIgnoreCase("no")) {
            System.out.print("Ingrese el número de cuenta del alumno que desea buscar: ");
            String numCuenta = scanner.nextLine();
            arbol.mostrarAlumno(numCuenta);

            System.out.print("¿Desea buscar otro alumno? (sí/no): ");
            opcion = scanner.nextLine();
        }

        scanner.close();
    }
}
