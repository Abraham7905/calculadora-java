import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> historial = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n=== CALCULADORA ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Ver historial");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingresa el primer número: ");
                double num1 = scanner.nextDouble();

                System.out.print("Ingresa el segundo número: ");
                double num2 = scanner.nextDouble();

                double resultado = 0;
                String operacion = "";

                switch (opcion) {
                    case 1:
                        resultado = sumar(num1, num2);
                        operacion = num1 + " + " + num2 + " = " + resultado;
                        break;
                    case 2:
                        resultado = restar(num1, num2);
                        operacion = num1 + " - " + num2 + " = " + resultado;
                        break;
                    case 3:
                        resultado = multiplicar(num1, num2);
                        operacion = num1 + " * " + num2 + " = " + resultado;
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("No se puede dividir entre 0");
                            continue;
                        }
                        resultado = dividir(num1, num2);
                        operacion = num1 + " / " + num2 + " = " + resultado;
                        break;
                }

                historial.add(operacion);
                System.out.println("Resultado: " + resultado);
            }

            if (opcion == 5) {
                System.out.println("\n=== HISTORIAL ===");
                if (historial.isEmpty()) {
                    System.out.println("No hay operaciones aún.");
                } else {
                    for (String op : historial) {
                        System.out.println(op);
                    }
                }
            }

        } while (opcion != 6);

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}