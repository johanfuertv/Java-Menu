package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class DataView extends JFrame {
    private JTextField inputField;
    private JButton inputButton;
    private JButton listButton;
    private JButton sumButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JLabel resultLabel;
    private JList<Integer> numberList;
    private JButton timerButton;

    public DataView() {
        setTitle("Data View");
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

    public void addInputListener(ActionListener listener) {
        inputButton.addActionListener(listener);
    }

    public void addListListener(ActionListener listener) {
        listButton.addActionListener(listener);
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

    public void addTimerListener(ActionListener listener) {
        timerButton.addActionListener(listener);
    }

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

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, "Numeros ingresados correctamente, no olvides iniciar el cronometro y listar los numeros");
    }

    public void displayNumbers(ArrayList<Integer> numbers) {
        Integer[] data = numbers.toArray(new Integer[0]);
        numberList.setListData(data);
    }

    public void displayResult(String result) {
    String resultText = result + ", Operación realizada por hilos";
    resultLabel.setText(resultText);
}

    public void displayProcessingMessage(String message) {
        resultLabel.setText(message);
    }

    public void setTimerButtonEnabled(boolean enabled) {
        timerButton.setEnabled(enabled);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Ingrese números separados por coma:");
        inputField = new JTextField(20);
        inputButton = new JButton("Agregar");
        panel.add(label);
        panel.add(inputField);
        panel.add(inputButton);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        listButton = new JButton("Listar");
        sumButton = new JButton("Sumar");
        subtractButton = new JButton("Restar");
        multiplyButton = new JButton("Multiplicar");
        timerButton = new JButton("Iniciar Cronómetro");
        panel.add(listButton);
        panel.add(sumButton);
         panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(timerButton);
        return panel;
    }private JPanel createResultPanel() {
        JPanel panel = new JPanel();
        resultLabel = new JLabel("Resultado: ");
        panel.add(resultLabel);
        return panel;
    }

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