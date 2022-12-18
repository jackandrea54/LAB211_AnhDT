/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import check.Check;
import entity.Student;
import java.util.ArrayList;
import validate.Validation;
import constant.Constant;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nguye
 */
public class ListStudent extends ArrayList<Student> {

    private final ArrayList<Student> listStudent = new ArrayList<>();
    private Map<String, Integer> uniqueStudent;

    public ListStudent() {
    }

    /**
     * Add a new student with not duplicate entry
     */
    public void addStudent() {
        Student student = new Student();
        while (true) {
            student.input();
            if (findById(student.getId()).isEmpty()==false) {
                System.out.println("Auto update name for exist student's ID");
                student.setName(findById(student.getId()).get(0).getName());
            }
            System.out.println(student);
            if (Check.checkDuplicateEntry(listStudent, student)) {
                System.out.println("Entry duplicate, enter again");
            } else {
                listStudent.add(student);
                return;
            }
        }
    }

    /**
     * Do option 1
     */
    public void OptionOne() {
        System.out.println("---------------------------------------------");
        System.out.println("CREATE STUDENT");
        String choose = "y";
        while (choose.equals("y") || choose.equals("Y")) {
            addStudent();
            if (listStudent.size() >= 2) {
                choose = Validation.getString("Do you want to continue (Y/N)",
                        "Only Y or N",
                        Constant.YN_FORM);
            }
        }
    }

    /**
     * Find student by Id
     *
     * @param Id is student's Id
     * @return student
     */
    public ArrayList<Student> findById(String Id) {
        ArrayList<Student> listByID = new ArrayList<>();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equals(Id)) {
                listByID.add(listStudent.get(i));
            }
        }
        return listByID;
    }

    /**
     * Find student by name
     *
     * @param name is input name to find
     * @return a list student have student's name contain parameter name
     */
    public ListStudent findByName(String name) {
        ListStudent listTemp = new ListStudent();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getName().contains(name)) {
                listTemp.add(listStudent.get(i));
            }
        }
        return listTemp;
    }

    /**
     * Find and sort student by name
     */
    public void OptionTwo() {
        System.out.println("FIND AND SORT BY NAME");
        String name = Validation.getString("Enter student name to find: ",
                "Invalid name, only alphaber character",
                Constant.NAME_FORM);
        ListStudent listTemp = findByName(name);
        if (listTemp.isEmpty()) {
            System.out.println("List does not contain this student");
        } else {
            Comparator<Student> comparator = Comparator.comparing(Student::getName)
                    .thenComparing(Student::getId)
                    .thenComparing(Student::getSemester);
            Collections.sort(listTemp, comparator);
            System.out.println("Student name\tSemester\tCourse Name");
            for (int i = 0; i < listTemp.size(); i++) {
                System.out.println(listTemp.get(i));
            }
        }
    }

    /**
     * Update student in list by Id
     *
     * @param Id is id of student to update
     */
    public void updateStudent(String Id) {
        System.out.println("-------------------------------------------------");
        ArrayList<Student> listById = findById(Id);
        for (int i = 0; i<listById.size(); i++) {
            System.out.println(i+" "+listById.get(i));
        }
        int index = Validation.getInt("Which student do you want to update ? ",
                "Index is out of range",
                "Not a valid number", 0, listById.size()-1);
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).equals(listById.get(index))) {
                System.out.println("UPDATE INFORMATION (STUDENT " + (index) + ")");
                Student newStudent = new Student();
                newStudent.input();
                listStudent.get(i).setId(newStudent.getId());
                listStudent.get(i).setName(newStudent.getName());
                listStudent.get(i).setSemester(newStudent.getSemester());
                listStudent.get(i).setCourse(newStudent.getCourse());
                return;
            }
        }
    }

    /**
     * Delete student in list by id
     *
     * @param Id is id of student to delete
     */
    public void deleteStudent(String Id) {
        System.out.println("-------------------------------------------------");
        ArrayList<Student> listById = findById(Id);
        for (int i = 0; i<listById.size(); i++) {
            System.out.println(i+" "+listById.get(i));
        }
        int index = Validation.getInt("Which student do you want to delete ? ",
                "Index is out of range",
                "Not a valid number", 0, listById.size()-1);
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).equals(listById.get(index))) {
                listStudent.remove(listStudent.get(i));
                System.out.println("DELETED!");
                return;
            }
        }
    }

    /**
     * Do option 3
     */
    public void OptionThree() {
        System.out.println("-------------------------------------------------");

        System.out.println("UPDATE OR DELETE");

        if (listStudent.isEmpty()) {
            System.out.println("List empty");
        }
        String choose = Validation.getString(
                "Do you want to update (U) or delete (D) student: ",
                "Choose is invalid, only U or D",
                Constant.UD_FORM);
        String id = Validation.getString("Enter student's id: ",
                "ID is invalid",
                Constant.ID_FORM);
        if (findById(id).isEmpty()) {
            System.out.println("List does not contain!");
            return;
        }
        if (choose.equals("U") || choose.equals("u")) {
            updateStudent(id);
        } else {
            deleteStudent(id);
        }
    }

    /**
     * Display list student
     */
    public void display() {
        if (listStudent.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).display();
        }
    }

    /**
     * Get map student and course is key and total is value
     *
     * @return map of student
     */
    public Map<String, Integer> getUnique() {
        uniqueStudent = new HashMap<>();
        for (int i = 0; i < listStudent.size(); i++) {
            String key = listStudent.get(i).getName() + "\t"
                    + listStudent.get(i).getCourse();
            if (uniqueStudent.containsKey(key)) {
                System.out.println("Change!");
                int value = uniqueStudent.get(key);
                uniqueStudent.replace(key, value, value + 1);
            } else {
                System.out.println("Add!");
                uniqueStudent.put(key, 1);
            }
        }
        return uniqueStudent;
    }
}
