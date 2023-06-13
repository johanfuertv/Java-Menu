package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.ArrayList;
import model.DataModel;
import view.DataView;

public class DataController {
    private DataModel model;
    private DataView view;
    private Timer timer;

    public DataController(DataModel model, DataView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(1000, new TimerListener());

        this.view.addInputListener(new InputListener());
        this.view.addListListener(new ListListener());
        this.view.addSumListener(new SumListener());
        this.view.addSubtractListener(new SubtractListener());
        this.view.addMultiplyListener(new MultiplyListener());
        this.view.addTimerListener(new TimerButtonListener());
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> inputData = view.getInputData();
            model.setNumbers(inputData);
            view.displayMessage("Datos ingresados correctamente.");
        }
    }

    private class ListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> numbers = model.getNumbers();
            view.displayNumbers(numbers);
        }
    }

    private class SumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayProcessingMessage("Realizando suma...");
            int sum = calculateSum();
            view.displayResult("Suma: " + sum);
        }
    }

    private class SubtractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayProcessingMessage("Realizando resta...");
            int subtraction = calculateSubtraction();
            view.displayResult("Resta: " + subtraction);
        }
    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayProcessingMessage("Realizando multiplicación...");
            int multiplication = calculateMultiplication();
            view.displayResult("Multiplicación: " + multiplication);
        }
    }

    private class TimerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning()) {
                timer.stop();
                view.setTimerButtonEnabled(true);
                view.displayProcessingMessage("Cronómetro detenido.");
            } else {
                timer.start();
                view.setTimerButtonEnabled(false);
                view.displayProcessingMessage("Cronómetro iniciado.");
            }
        }
    }

    private class TimerListener implements ActionListener {
        private int count = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            view.displayProcessingMessage("Proceso adicional en ejecución: " + count + " segundos");
        }
    }

    public int calculateSum() {
        ArrayList<Integer> numbers = model.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
     public int calculateSubtraction() {
        ArrayList<Integer> numbers = model.getNumbers();
        int subtraction = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            subtraction -= numbers.get(i);
        }
        return subtraction;
    }

    public int calculateMultiplication() {
        ArrayList<Integer> numbers = model.getNumbers();
        int multiplication = 1;
        for (int number : numbers) {
            multiplication *= number;
        }
        return multiplication;
    }

    public static void main(String[] args) {
        DataModel model = new DataModel();
        DataView view = new DataView();
        DataController controller = new DataController(model, view);
        view.setVisible(true);
    }
}