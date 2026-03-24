import java.util.ArrayList;
import java.util.List;

public class CalculadoraService {

    private List<String> historial = new ArrayList<>();

    public double sumar(double a, double b) {
        double resultado = a + b;
        historial.add(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public double restar(double a, double b) {
        double resultado = a - b;
        historial.add(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public double multiplicar(double a, double b) {
        double resultado = a * b;
        historial.add(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        double resultado = a / b;
        historial.add(a + " / " + b + " = " + resultado);
        return resultado;
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}