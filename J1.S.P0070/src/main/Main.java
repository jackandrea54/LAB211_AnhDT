package main;

import java.util.Locale;
import java.util.ResourceBundle;
import service.LoginService;
import util.Helper;
import util.Validation;

public class Main {
    
    public static void main(String[] args) {
        Helper.menu();
        int choice = Validation.getInteger(1, 3,
                "Please choice one option: ",
                "Number value out of range",
                "Invalid integer number");
        switch (choice) {
            case 1:
                Locale.setDefault(new Locale("vi", "VN"));
                break;
            case 2:
                Locale.setDefault(new Locale("en", "US"));
                break;
            case 3:
                System.exit(0);
                break;
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/Language");
        new LoginService().LoginProcess(resourceBundle);
    }
    
}
