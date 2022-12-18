/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Locale;
import java.util.ResourceBundle;
import service.Ebank;
import constant.Constant;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale locale = null;
        Ebank ebank = new Ebank();
        ResourceBundle resourceBundle;
        System.out.println("------------ Login Program ------------ ");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = Validation.getInteger(
                "Please choose one option: ",
                "Number value out of range",
                "Invalid integer number",
                1,
                3
        );
        switch (choice) {
            case 1:
                locale = new Locale("vi");
                break;
            case 2:
                locale = new Locale("en");
                break;
            case 3:
                choice = Constant.EXIT_INDEX;
                break;
        }
        if (choice != Constant.EXIT_INDEX) {
            resourceBundle = ResourceBundle.getBundle("resources/language", locale);
            boolean checkLogin = ebank.checkLogin(resourceBundle);
            if (checkLogin) {
                System.out.println(resourceBundle.getString("loginSuccess"));
            }
            else{
                System.out.println(resourceBundle.getString("loginFailed"));
            }
        }
    }
    
}
