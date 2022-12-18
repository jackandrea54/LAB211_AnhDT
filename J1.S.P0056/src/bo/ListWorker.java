/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.History;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author nguye
 */
public class ListWorker {

    private ArrayList<Worker> listWorker = new ArrayList<>();
    private ArrayList<History> listHistory = new ArrayList<>();

    public ListWorker() {
    }

    /**
     * Add a new worker into listWorker
     *
     * @param worker is new worker
     */
    public void addWorker(Worker worker) {
        listWorker.add(worker);
        System.out.println("-------------------------------------------------");
    }

    /**
     * Find worker that has id exist in listWorker
     *
     * @param id is worker's id
     * @return Worker if exist, null if not
     */
    public Worker findWorker(String id) {
        for (int i = 0; i < listWorker.size(); i++) {
            if (listWorker.get(i).getId().equals(id)) {
                return listWorker.get(i);
            }
        }
        return null;
    }

    /**
     * Get current date time
     *
     * @return current date time
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    /**
     * Display listWorker
     */
    public void display() {
        for (int i = 0; i < listWorker.size(); i++) {
            System.out.println(listWorker.get(i));
        }
    }

    /**
     * Change salary of worker
     *
     * @param id        to find worker
     * @param amount    amount of money to decrease or increase
     * @param status    decrease or increase
     */
    public void changeSalary(String id, double amount, String status) {
        if (listWorker.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        Worker oldWorker = findWorker(id);
        Worker worker = new Worker(id,
                oldWorker.getName(),
                 oldWorker.getAge(),
                oldWorker.getSalary(),
                oldWorker.getWorkLocation());
        if (status.equals("UP")) {
            worker.setSalary(worker.getSalary() + amount);
        } else {
            worker.setSalary(worker.getSalary() - amount);
        }
        History history = new History(worker, status, getCurrentDate());
        listHistory.add(history);
        oldWorker.setSalary(oldWorker.getSalary() + amount);
        System.out.println("Update success");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Display history change salary
     */
    public void displayHistory() {
        Comparator<History> comparator = Comparator.comparing(History::getId)
                .thenComparing(History::getDate);
        listHistory.sort(comparator);
        System.out.println("ID\tName\tAge\tSalary\tStatus\tDate");
        for (int i = 0; i < listHistory.size(); i++) {
            listHistory.get(i).display();
        }
        System.out.println("-------------------------------------------------");
    }
}
