/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Constant;
import entity.Task;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class TaskManagement {

    private int taskID = 1;
    private ArrayList<Task> listTask = new ArrayList<Task>();

    public void addTask() {
        String requireName = Validation.getString(
                "Requirement Name: ",
                "Wrong format, please input a valid name",
                Constant.NAME_REGEX
        );
        int taskType = Validation.getInteger(
                "Task Type (1-Code; 2-Test; 3-Design; 4-Review): ",
                "Please input task type within choice range",
                "Please enter a valid integer",
                1,
                4
        );
        String date = Validation.getString(
                "Date: ",
                "Wrong format, please input a valid date",
                Constant.DATE_REGEX
        );
        double fromTime = Validation.getDouble(
                "Plan from: ",
                "Please input a plan time in between 8.0 and 17.5",
                "Please enter a valid double value",
                8.0,
                17.5
        );
        double toTime = Validation.getDouble(
                "Plan to: ",
                "Please input a plan time in between " + fromTime + " 17.5",
                "Please enter a valid double value",
                fromTime + 0.01,
                17.5
        );
        String assignee = Validation.getString(
                "Assignee: ",
                "Wrong format, please input a valid name",
                Constant.NAME_REGEX
        );
        String reviewer = Validation.getString(
                "Reviewer: ",
                "Wrong format, please input a valid name",
                Constant.NAME_REGEX
        );
        listTask.add(new Task(taskID, taskType, requireName, date, fromTime, toTime, assignee, reviewer));
        taskID += 1;
    }

    public void deleteTask() {
        if (listTask.isEmpty()) {
            System.out.println("List task is empty!");
        } else {
            int deleteID = Validation.getInteger(
                    "ID: ",
                    "Please input ID within tasks number range(" + 1 + "," + taskID + ")",
                    "Please enter a valid integer",
                    1,
                    taskID-1
            );
            boolean deleted = false;
            for (int i = 0; i < listTask.size() && !deleted; i++) {
                if (deleteID == listTask.get(i).getID()) {
                    listTask.remove(i);
                    deleted = true;
                }
            }
            if (deleted) {
                System.out.println("Delete successfully");
            } else {
                System.out.println("Index not found. Delete unsuccessfully");
            }
        }
    }

    public void showTask() {
        if (listTask.isEmpty()) {
            System.out.println("List task is empty!");
        } else {
            System.out.println("ID   Name           Task Type      Date           Time   Assignee       Reviewer");
            for (int i = 0; i < listTask.size(); i++) {
                Task task = listTask.get(i);
                double time = task.getPlanTo() - task.getPlanFrom();
                String taskType = "";
                switch (task.getTaskTypeID()) {
                    case 1:
                        taskType = "Code";
                        break;
                    case 2:
                        taskType = "Test";
                        break;
                    case 3:
                        taskType = "Design";
                        break;
                    case 4:
                        taskType = "Review";
                        break;
                }

                System.out.printf("%-5d%-15s%-15s%-15s%-7.1f%-15s%s\n",
                        task.getID(),
                        task.getRequirementName(),
                        taskType,
                        task.getDate(),
                        time,
                        task.getAssignee(),
                        task.getreviewer()
                );
            }
        }
    }

}
