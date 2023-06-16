package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

// La clase DataView representa la vista en el patrón de diseño Modelo-Vista-Controlador (MVC).
public class DataView extends JFrame {
    private JTextField inputField; // Campo de texto para ingresar datos
    private JButton inputButton; // Botón para ingresar datos
    private JButton listButton; // Botón para mostrar la lista de números
    private JButton sumButton; // Botón para realizar la suma
    private JButton subtractButton; // Botón para realizar la resta
    private JButton multiplyButton; // Botón para realizar la multiplicación
    private JButton timerButton; // Botón para controlar el cronómetro
    private JButton aboutButton; // Botón para mostrar información acerca de la aplicación

    private JLabel resultLabel; // Etiqueta para mostrar el resultado
    private JList<Integer> numberList; // Lista para mostrar los números ingresados
    private JLabel imageLabel; // Etiqueta para mostrar una imagen

    // Constructor de la clase DataView.
    public DataView() {
        setTitle("Aplicacion con hilos operaciones con cronometro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel resultPanel = createResultPanel();
        JPanel listPanel = createListPanel();

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
        add(listPanel, BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null);
    }

    // Método para agregar un ActionListener al botón de ingresar datos.
    public void addInputListener(ActionListener listener) {
        inputButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de mostrar la lista de números.
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

    // Método para agregar un ActionListener al botón del cronómetro.
    public void addTimerListener(ActionListener listener) {
        timerButton.addActionListener(listener);
    }

    // Método para agregar un ActionListener al botón de información acerca de la aplicación.
    public void addAboutListener(ActionListener listener) {
        aboutButton.addActionListener(listener);
    }

    // Método para obtener los datos ingresados por el usuario como una lista de enteros.
    public ArrayList<Integer> getInputData() {
        ArrayList<Integer> data = new ArrayList<>();
        String[] inputValues = inputField.getText().split(",");
        for (String value : inputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                data.add(number);
            } catch (NumberFormatException e) {
                // Ignorar valores no numéricos
            }
        }
        return data;
    }
    // Método para mostrar un mensaje en un cuadro de diálogo.
public void displayMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
}

// Método para mostrar los números en la lista.
public void displayNumbers(ArrayList<Integer> numbers) {
    Integer[] data = numbers.toArray(new Integer[0]);
    numberList.setListData(data);
}

// Método para mostrar el resultado de una operación.
public void displayResult(String result) {
    String resultText = result + ", Operación realizada por hilos";
    resultLabel.setText(resultText);
}

// Método para mostrar un mensaje de procesamiento.
public void displayProcessingMessage(String message) {
    resultLabel.setText(message);
}

// Método para habilitar o deshabilitar el botón del cronómetro.
public void setTimerButtonEnabled(boolean enabled) {
    timerButton.setEnabled(enabled);
}

// Método para mostrar información acerca de la aplicación.
public void displayAboutInfo(String info, BufferedImage image) {
    JDialog aboutDialog = new JDialog(this, "Acerca de...", true);
    aboutDialog.setLayout(new BorderLayout());
    aboutDialog.setSize(600, 600);

    JLabel infoLabel = new JLabel(info);
    aboutDialog.add(infoLabel, BorderLayout.CENTER);

    if (image != null) {
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        aboutDialog.add(imageLabel, BorderLayout.NORTH);
    }

    aboutDialog.setLocationRelativeTo(this);
    aboutDialog.setVisible(true);
}

// Método privado para crear el panel de entrada de datos.
private JPanel createInputPanel() {
    JPanel panel = new JPanel();
    inputField = new JTextField(20);
    inputButton = new JButton("Ingresar");
    panel.add(inputField);
    panel.add(inputButton);
    return panel;
}

// Método privado para crear el panel de botones.
private JPanel createButtonPanel() {
    JPanel panel = new JPanel();
    listButton = new JButton("Mostrar Lista");
    sumButton = new JButton("Sumar");
    subtractButton = new JButton("Restar");
    multiplyButton = new JButton("Multiplicar");
    timerButton = new JButton("Cronómetro");
    aboutButton = new JButton("Acerca de");

    panel.add(listButton);
    panel.add(sumButton);
    panel.add(subtractButton);
    panel.add(multiplyButton);
    panel.add(timerButton);
    panel.add(aboutButton);
    return panel;
}

// Método privado para crear el panel de resultados.
private JPanel createResultPanel() {
    JPanel panel = new JPanel();
    resultLabel = new JLabel("Resultado: ");
    panel.add(resultLabel);
    return panel;
}

// Método privado para crear el panel de la lista de números.
private JPanel createListPanel() {
    JPanel panel = new JPanel();
    numberList = new JList<>();
    numberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(numberList);
    scrollPane.setPreferredSize(new Dimension(100, 200));
    panel.add(scrollPane);
    return panel;
}
}