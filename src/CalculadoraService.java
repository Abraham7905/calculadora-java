import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraService {

    private List<String> historial = new ArrayList<>();
    private final String FILE_PATH = "historial.txt";

    public CalculadoraService() {
        cargarHistorial();
    }

    public double sumar(double a, double b) {
        double resultado = a + b;
        guardarOperacion(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public double restar(double a, double b) {
        double resultado = a - b;
        guardarOperacion(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public double multiplicar(double a, double b) {
        double resultado = a * b;
        guardarOperacion(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        double resultado = a / b;
        guardarOperacion(a + " / " + b + " = " + resultado);
        return resultado;
    }

    private void guardarOperacion(String operacion) {
        historial.add(operacion);
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(operacion);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar historial");
        }
    }

    private void cargarHistorial() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                historial.add(linea);
            }
        } catch (IOException e) {
            // Primera ejecución, no pasa nada
        }
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}