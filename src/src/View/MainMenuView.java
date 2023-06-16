package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// La clase MainMenuView representa la vista principal en el patrón de diseño Modelo-Vista-Controlador (MVC).
public class MainMenuView extends JFrame {
    private JButton inputButton; // Botón para ingresar a la aplicación
    private JButton listButton; // Botón para listar los números
    private JButton sumButton; // Botón para realizar la suma
    private JButton subtractButton; // Botón para realizar la resta
    private JButton multiplyButton; // Botón para realizar la multiplicación
    private JButton aboutButton; // Botón para mostrar información acerca de la aplicación

    // Constructor de la clase MainMenuView.
    public MainMenuView() {
        setTitle("Aplicación con Hilos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        inputButton = new JButton("Ingresar a la aplicacion para el funcionamiento.");
        listButton = new JButton("Listar");
        sumButton = new JButton("Suma");
        subtractButton = new JButton("Resta");
        multiplyButton = new JButton("Multiplicación");
        aboutButton = new JButton("Acerca de");

        buttonPanel.add(inputButton);
        buttonPanel.add(listButton);
        buttonPanel.add(sumButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(aboutButton);

        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    // Método para agregar un ActionListener al botón de ingresar a la aplicación.
    public void addInputListener(ActionListener listener) {
        inputButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de listar los números.
    public void addListListener(ActionListener listener) {
        listButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de realizar la suma.
    public void addSumListener(ActionListener listener) {
        sumButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de realizar la resta.
    public void addSubtractListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de realizar la multiplicación.
    public void addMultiplyListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de información acerca de la aplicación.
    public void addAboutListener(ActionListener listener) {
        aboutButton.addActionListener(listener);
    }

    // Método para mostrar información acerca de la aplicación en un cuadro de diálogo.
    public void displayAboutInfo(String info) {
        JOptionPane.showMessageDialog(this, info, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para cargar una imagen desde una ruta de archivo.
    public BufferedImage loadImage(String imagePath) {
        try {
            URL url = getClass().getResource("/imagenes/dead-by-daylight.jpg");
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}