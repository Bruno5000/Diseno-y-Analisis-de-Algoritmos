class Nodo {
    int valor;
    Nodo rama1, rama2, rama3;

    // Constructor para inicializar el nodo con un valor
    public Nodo(int valor) {
        this.valor = valor;
        this.rama1 = this.rama2 = this.rama3 = null;
    }

    // Método para agregar un nodo a una rama específica
    public void agregarNodo(int valor, int rama) {
        switch (rama) {
            case 1:
                this.rama1 = new Nodo(valor);
                break;
            case 2:
                this.rama2 = new Nodo(valor);
                break;
            case 3:
                this.rama3 = new Nodo(valor);
                break;
            default:
                throw new IllegalArgumentException("Rama no válida. Usa 1, 2 o 3.");
        }
    }

    // Método para agregar un nodo nulo (con valor 0) a una rama específica
    public void agregarNodoNulo(int rama) {
        agregarNodo(0, rama);
    }

    // Método para mover el pivote a una rama específica
    public Nodo moverAPivote(int direccion) {
        Nodo siguienteNodo = null;
        switch (direccion) {
            case 1:
                siguienteNodo = this.rama1;
                break;
            case 2:
                siguienteNodo = this.rama2;
                break;
            case 3:
                siguienteNodo = this.rama3;
                break;
            default:
                throw new IllegalArgumentException("Dirección no válida. Usa 1, 2 o 3.");
        }
        return (siguienteNodo != null) ? siguienteNodo : this;
    }

    // Método para imprimir el valor del nodo actual
    public void imprimirValor() {
        System.out.println("Estamos en el nodo con valor de: " + this.valor);
    }
}

class Pivote {
    Nodo nodoActual;
    java.util.Stack<Nodo> historial;

    // Constructor que inicializa el pivote en el nodo inicial
    public Pivote(Nodo nodoInicial) {
        this.nodoActual = nodoInicial;
        this.historial = new java.util.Stack<>();
        this.historial.push(nodoInicial);
    }

    // Método para moverse a un nodo en una dirección específica y agregarlo al historial
    public Nodo moverse(int direccion) {
        Nodo nuevoNodo = this.nodoActual.moverAPivote(direccion);
        if (nuevoNodo != this.nodoActual) {
            this.historial.push(nuevoNodo);
            this.nodoActual = nuevoNodo;
        }
        return this.nodoActual;
    }

    // Método para regresar al nodo anterior en el historial
    public Nodo regresar() {
        if (this.historial.size() > 1) {
            this.historial.pop();
            this.nodoActual = this.historial.peek();
        } else {
            System.out.println("No puedes retroceder más.");
        }
        return this.nodoActual;
    }

    // Método para imprimir el valor del nodo actual
    public void imprimirValor() {
        this.nodoActual.imprimirValor();
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear el árbol
        Nodo head = new Nodo(20);
        head.agregarNodo(23, 1);
        head.agregarNodo(19, 2);
        head.agregarNodoNulo(3);

        head.rama1.agregarNodoNulo(1);
        head.rama1.agregarNodo(57, 2);
        head.rama1.agregarNodoNulo(3);

        head.rama2.agregarNodoNulo(1);
        head.rama2.agregarNodoNulo(2);
        head.rama2.agregarNodo(67, 3);

        head.rama2.rama3.agregarNodoNulo(1);
        head.rama2.rama3.agregarNodo(99, 2);
        head.rama2.rama3.agregarNodoNulo(3);

        // Movimiento entre nodos
        System.out.println("Empezamos en el nodo cabeza");
        Pivote pivote = new Pivote(head);
        pivote.imprimirValor();
        System.out.println("//////////////////////////////");

        System.out.println("Vamos al nodo del final");
        pivote.moverse(1);
        pivote.moverse(2);
        pivote.imprimirValor();
        System.out.println("//////////////////////////////");

        System.out.println("Regresamos al nodo inicial o al nodo cabeza");
        System.out.println("Regresando...");
        pivote.regresar();
        System.out.println("Regresando...");
        pivote.regresar();

        System.out.println("//////////////////////////////");
        System.out.println("Vamos al ultimo nodo del centro");
        pivote.moverse(2);
        pivote.moverse(3);
        pivote.moverse(2);

        pivote.imprimirValor();
    }
}
