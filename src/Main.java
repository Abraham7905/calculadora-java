import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraService calc = new CalculadoraService();
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

            try {
                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Número 1: ");
                    double a = scanner.nextDouble();

                    System.out.print("Número 2: ");
                    double b = scanner.nextDouble();

                    double resultado = 0;

                    switch (opcion) {
                        case 1:
                            resultado = calc.sumar(a, b);
                            break;
                        case 2:
                            resultado = calc.restar(a, b);
                            break;
                        case 3:
                            resultado = calc.multiplicar(a, b);
                            break;
                        case 4:
                            resultado = calc.dividir(a, b);
                            break;
                    }

                    System.out.println("Resultado: " + resultado);
                }

                if (opcion == 5) {
                    System.out.println("\n=== HISTORIAL ===");
                    for (String op : calc.obtenerHistorial()) {
                        System.out.println(op);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 6);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}