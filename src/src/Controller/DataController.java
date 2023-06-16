package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.ArrayList;
import model.DataModel;
import view.DataView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import view.MainMenuView;

public class DataController {
    private DataModel model;
    private DataView view;
    private Timer timer;

    public DataController(DataModel model, DataView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(1000, new TimerListener());

        // Asociar los listener a los componentes de la vista
        this.view.addInputListener(new InputListener());
        this.view.addListListener(new ListListener());
        this.view.addSumListener(new SumListener());
        this.view.addSubtractListener(new SubtractListener());
        this.view.addMultiplyListener(new MultiplyListener());
        this.view.addTimerListener(new TimerButtonListener());
        this.view.addAboutListener(new AboutButtonListener());
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener datos de entrada del DataView
            ArrayList<Integer> inputData = view.getInputData();
            // Establecer los números en el modelo de datos
            model.setNumbers(inputData);
            // Mostrar mensaje en la vista
            view.displayMessage("Datos ingresados correctamente, no olvides que para hacer las operaciones con hilos debes agregar dos números separados por coma y activar el cronómetro.");
        }
    }

    private class ListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener los números del modelo de datos
            ArrayList<Integer> numbers = model.getNumbers();
            // Mostrar los números en la vista
            view.displayNumbers(numbers);
        }
    }

    private class SumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar mensaje de procesamiento en la vista
            view.displayProcessingMessage("Realizando suma...");
            // Calcular la suma utilizando el método correspondiente
            int sum = calculateSum();
            // Mostrar el resultado en la vista
            view.displayResult("Suma: " + sum);
        }
    }

    private class SubtractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar mensaje de procesamiento en la vista
            view.displayProcessingMessage("Realizando resta...");
            // Calcular la resta utilizando el método correspondiente
            int subtraction = calculateSubtraction();
            // Mostrar el resultado en la vista
            view.displayResult("Resta: " + subtraction);
        }
    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar mensaje de procesamiento en la vista
            view.displayProcessingMessage("Realizando multiplicación...");
            // Calcular la multiplicación utilizando el método correspondiente
            int multiplication = calculateMultiplication();
            // Mostrar el resultado en la vista
            view.displayResult("Multiplicación: " + multiplication);
        }
    }

    private class TimerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning()) {
                // Si el cronómetro está en ejecución, detenerlo
                timer.stop();
                // Habilitar el botón del cronómetro en la vista
                view.setTimerButtonEnabled(true);
                // Mostrar mensaje en la vista view.displayProcessingMessage("Cronómetro detenido.");
            } else {
                // Si el cronómetro no está en ejecución, iniciarlo
                timer.start();
                // Deshabilitar el botón del cronómetro en la vista
                view.setTimerButtonEnabled(false);
                // Mostrar mensaje en la vista
                view.displayProcessingMessage("Cronómetro iniciado.");
            }
        }
    }

    private class TimerListener implements ActionListener {
        private int count = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Incrementar el contador cada segundo
            count++;
            // Mostrar mensaje de procesamiento en la vista con el tiempo transcurrido
            view.displayProcessingMessage("Proceso adicional en ejecución: " + count + " segundos");
        }
    }

    private class AboutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Información sobre el autor y la versión de la aplicación
            String info = "Johan Ossa - Code: 2257642 - App Version: 1.0";
            // Cargar imagen desde un archivo
            BufferedImage image = loadImage("/imagenes/dead-by-daylight.jpg");
            // Mostrar la información y la imagen en la vista
            view.displayAboutInfo(info, image);
        }

        private BufferedImage loadImage(String path) {
            try {
                // Obtener la URL del recurso de la imagen
                URL imageURL = getClass().getResource("/imagenes/dead-by-daylight.jpg");
                if (imageURL != null) {
                    // Leer la imagen desde la URL
                    return ImageIO.read(imageURL);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    // Método para calcular la suma de los números en el modelo de datos
    public int calculateSum() {
        ArrayList<Integer> numbers = model.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Método para calcular la resta de los números en el modelo de datos
    public int calculateSubtraction() {
        ArrayList<Integer> numbers = model.getNumbers();
        int subtraction = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            subtraction -= numbers.get(i);
        }
        return subtraction;
    }

    // Método para calcular la multiplicación de los números en el modelo de datos
    public int calculateMultiplication() {
        ArrayList<Integer> numbers = model.getNumbers();
        int multiplication = 1;
        for (int number : numbers) {
            multiplication *= number;
        }
        return multiplication;
    }

    public static void main(String[] args) {
        // Crear instancias de las vistas y el modelo
        MainMenuView mainMenuView = new MainMenuView();
        DataView dataView = new DataView();
        DataModel dataModel = new DataModel();
        // Crear una instancia del controlador y pasar las instancias de las vistas y el modelo
        DataController controller = new DataController(dataModel, dataView);

        // Asociar listeners a los componentes de la vista del menú principal
        mainMenuView.addInputListener(e -> {
            dataView.setVisible(true);
            mainMenuView.setVisible(false);
        });

        mainMenuView.addSumListener(e -> {
            controller.calculateSum();
        });

        mainMenuView.addSubtractListener(e -> {
            controller.calculateSubtraction();
        });

        mainMenuView.addMultiplyListener(e -> {
            controller.calculateMultiplication();
        });

        // Mostrar la vista del menú
        mainMenuView.setVisible(true);
    }
}