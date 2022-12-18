package main;

import bo.Validator;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====Validate Program=====");
        Validator validator = new Validator();
        validator.getPhoneNumber();
        validator.getEmail();
        validator.getDate();
    }
}
