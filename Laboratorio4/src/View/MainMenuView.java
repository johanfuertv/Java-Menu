package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuView extends JFrame {
    private JButton inputButton;
    private JButton sumButton;
    private JButton subtractButton;
    private JButton multiplyButton;

    public MainMenuView() {
        setTitle("Aplicación con Hilos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        inputButton = new JButton("Ingresar Datos");
        sumButton = new JButton("Suma");
        subtractButton = new JButton("Resta");
        multiplyButton = new JButton("Multiplicación");

        buttonPanel.add(inputButton);
        buttonPanel.add(sumButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);

        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public void addInputListener(ActionListener listener) {
        inputButton.addActionListener(listener);
    }

    public void addSumListener(ActionListener listener) {
        sumButton.addActionListener(listener);
    }

    public void addSubtractListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    public void addMultiplyListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }
}