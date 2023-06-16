package model;

import java.util.ArrayList;
import view.DataView;
import view.MainMenuView;
import Controller.DataController;

// La clase DataModel representa el modelo de datos en el patrón de diseño Modelo-Vista-Controlador (MVC).
public class DataModel {
    private ArrayList<Integer> numbers; // Lista de números ingresados por el usuario
    private DataView Dataview; // Vista de los datos
    private MainMenuView MainMenuview; // Vista del menú principal
    private DataController Datacontroller; // Controlador de datos

    // Constructor de la clase DataModel. Inicializa la lista de números vacía.
    public DataModel() {
        numbers = new ArrayList<>();
    }

    // Establece la lista de números con la lista proporcionada como argumento.
    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    // Obtiene la lista de números almacenados en el modelo.
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}