/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.TaskManagement;
import constant.Constant;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        TaskManagement taskMang = new TaskManagement();
        int choice;
        do {
            System.out.println("============== Task Program ==============");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            choice = Validation.getInteger(
                    "Please choose one option: ",
                    "Number value out of range",
                    "Invalid integer number",
                    1,
                    4
            );
            switch (choice) {
                case 1:
                    System.out.println("------------------ Add Task ------------------");
                    taskMang.addTask();
                    break;
                case 2:
                    System.out.println("------------------ Delete Task ------------------");
                    taskMang.deleteTask();
                    break;
                case 3:
                    System.out.println("------------------------------------ Task ------------------------------------");
                    taskMang.showTask();
                    break;
                case 4:
                    choice = Constant.EXIT_INDEX;
                    break;
            }
        } while (choice != Constant.EXIT_INDEX);
    }

}
