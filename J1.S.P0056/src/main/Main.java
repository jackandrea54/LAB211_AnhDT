/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.ListWorker;
import validate.Validation;
import entity.Worker;
import constant.Constant;

/**
 *
 * @author nguye
 */
public class Main {

    public static void main(String[] args) {
        String id;
        Worker worker;
        ListWorker listWorker = new ListWorker();
        System.out.println("======== Worker Management =========\n"
                + "1.	Add Worker\n"
                + "2.	Up salary\n"
                + "3.	Down salary\n"
                + "4.	Display Information salary\n"
                + "5.	Exit");
        while (true) {
            int choice = Validation.getInt("Enter your choice:",
                    "Number is out of range",
                    "Number is invalid", 1, 5);
            switch (choice) {
                case 1:
                    System.out.println("--------- Add Worker ----------");
                    worker = new Worker();
                    worker.input();
                    if (listWorker.findWorker(worker.getId()) == null) {
                        listWorker.addWorker(worker);
                    } else {
                        System.out.println("Worker existed");
                    }
                    break;
                case 2:
                    System.out.println("------- Up Salary --------");
                    id = Validation.getString("Enter worker's ID:",
                            "Not a valid ID", Constant.ID_FORM);
                    worker = listWorker.findWorker(id);
                    if (worker != null) {
                        double newSalary = Validation.getDouble("Enter amount:",
                                "Must be positive",
                                "Not a valid number",
                                0.00001, Double.MAX_VALUE);
                        listWorker.changeSalary(id, newSalary, "UP");
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 3:
                    System.out.println("------- Down Salary --------");
                    id = Validation.getString("Enter worker's ID:",
                            "Not a valid ID", Constant.ID_FORM);
                    worker = listWorker.findWorker(id);
                    if (worker != null) {
                        double newSalary = Validation.getDouble("Enter amount:",
                                "Number is out of range",
                                "Not a valid number",
                                0.000001, worker.getSalary());
                        listWorker.changeSalary(id, newSalary, "DOWN");
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 4:
                    System.out.println("------Display Information Salary-------");
                    listWorker.displayHistory();
                    break;
                case 5:
                    return;
            }
        }
    }
}
