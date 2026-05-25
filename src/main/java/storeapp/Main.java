package storeapp;

import storeapp.infraestructure.config.Config;
import storeapp.userinterface.MenuApp;

public class Main {

    public static void main(String[] args) {


        MenuApp menuApp = Config.createMenuApp();

            menuApp.showMainMenu();
    }
}
