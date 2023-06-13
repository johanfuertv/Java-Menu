package model;

import java.util.ArrayList;

public class DataModel {
    private ArrayList<Integer> numbers;

    public DataModel() {
        numbers = new ArrayList<>();
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}