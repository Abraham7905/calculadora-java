import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculadoraGUI {

    private CalculadoraService calc = new CalculadoraService();

    public CalculadoraGUI() {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JLabel resultado = new JLabel("Resultado:");

        JButton sumar = new JButton("Sumar");
        JButton restar = new JButton("Restar");
        JButton multiplicar = new JButton("Multiplicar");
        JButton dividir = new JButton("Dividir");

        ActionListener listener = e -> {
            try {
                double a = Double.parseDouble(num1.getText());
                double b = Double.parseDouble(num2.getText());
                double res = 0;

                if (e.getSource() == sumar) res = calc.sumar(a, b);
                if (e.getSource() == restar) res = calc.restar(a, b);
                if (e.getSource() == multiplicar) res = calc.multiplicar(a, b);
                if (e.getSource() == dividir) res = calc.dividir(a, b);

                resultado.setText("Resultado: " + res);

            } catch (Exception ex) {
                resultado.setText("Error");
            }
        };

        sumar.addActionListener(listener);
        restar.addActionListener(listener);
        multiplicar.addActionListener(listener);
        dividir.addActionListener(listener);

        frame.add(new JLabel("Número 1:"));
        frame.add(num1);
        frame.add(new JLabel("Número 2:"));
        frame.add(num2);

        frame.add(sumar);
        frame.add(restar);
        frame.add(multiplicar);
        frame.add(dividir);

        frame.add(resultado);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}