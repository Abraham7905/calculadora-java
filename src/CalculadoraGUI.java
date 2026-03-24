import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI {

    private CalculadoraService calc = new CalculadoraService();

    public CalculadoraGUI() {
        JFrame frame = new JFrame("Calculadora PRO");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel superior (inputs)
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JLabel resultado = new JLabel("Resultado: ");

        topPanel.add(new JLabel("Número 1:"));
        topPanel.add(num1);
        topPanel.add(new JLabel("Número 2:"));
        topPanel.add(num2);
        topPanel.add(resultado);

        // Panel botones
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton sumar = new JButton("Sumar");
        JButton restar = new JButton("Restar");
        JButton multiplicar = new JButton("Multiplicar");
        JButton dividir = new JButton("Dividir");

        buttonPanel.add(sumar);
        buttonPanel.add(restar);
        buttonPanel.add(multiplicar);
        buttonPanel.add(dividir);

        // Historial
        DefaultListModel<String> modeloHistorial = new DefaultListModel<>();
        JList<String> listaHistorial = new JList<>(modeloHistorial);
        JScrollPane scroll = new JScrollPane(listaHistorial);

        // Cargar historial existente
        for (String op : calc.obtenerHistorial()) {
            modeloHistorial.addElement(op);
        }

        // Acción botones
        java.awt.event.ActionListener listener = e -> {
            try {
                double a = Double.parseDouble(num1.getText());
                double b = Double.parseDouble(num2.getText());
                double res = 0;

                if (e.getSource() == sumar) res = calc.sumar(a, b);
                if (e.getSource() == restar) res = calc.restar(a, b);
                if (e.getSource() == multiplicar) res = calc.multiplicar(a, b);
                if (e.getSource() == dividir) res = calc.dividir(a, b);

                resultado.setText("Resultado: " + res);

                modeloHistorial.clear();
                for (String op : calc.obtenerHistorial()) {
                    modeloHistorial.addElement(op);
                }

            } catch (Exception ex) {
                resultado.setText("Error: " + ex.getMessage());
            }
        };

        sumar.addActionListener(listener);
        restar.addActionListener(listener);
        multiplicar.addActionListener(listener);
        dividir.addActionListener(listener);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scroll, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}