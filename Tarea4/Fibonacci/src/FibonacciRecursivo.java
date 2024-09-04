import java.util.Scanner;

public class FibonacciRecursivo {

    // Método recursivo para la serie de fibonalli
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de términos
        System.out.print("Introduce el número de términos en la serie de Fibonacci: ");
        int n = scanner.nextInt();

        System.out.println("Serie de Fibonacci hasta el término " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        scanner.close();
    }
}
