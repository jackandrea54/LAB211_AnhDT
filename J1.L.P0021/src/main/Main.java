/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.ListStudent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import validate.Validation;

/**
 *
 * @author nguye
 */
public class Main {

    public static void main(String[] args) {
        String messageInfoInt = "Enter your choice (1-6):";
        String messageErrorOutOfRange = "Number is out of range";
        String messageErrorInvalidNumber = "Number is invalid";
        ListStudent listStudent = new ListStudent();
        while (true) {
            int choice = Validation.getInt(messageInfoInt, messageErrorOutOfRange, messageErrorInvalidNumber, 1, 6);
            switch (choice) {
                case 1:
                    listStudent.OptionOne();
                    break;
                case 2:
                    listStudent.OptionTwo();
                    break;
                case 3:
                    listStudent.OptionThree();
                    break;
                case 4:
                    Map<String, Integer> uniqueStudent = listStudent.getUnique();
                    Set<String> set = uniqueStudent.keySet();
                    System.out.println("Name\tCourse\tTotal");
                    for (String key : set) {
                        System.out.println(key + "\t" + uniqueStudent.get(key));
                    }
                    break;
                case 5:
                    listStudent.display();
                    break;
                case 6:
                    return;
            }
        }
    }
}
