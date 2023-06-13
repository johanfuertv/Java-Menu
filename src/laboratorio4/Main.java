/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio4;

import View.MainMenuView;

import Controller.DataController;
import model.DataModel;
import view.DataView;

public class Main {
    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        DataView dataView = new DataView();
        DataModel dataModel = new DataModel();
        DataController controller = new DataController(dataModel, dataView);

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

        mainMenuView.setVisible(true);
    }
}