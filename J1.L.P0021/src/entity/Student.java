/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.Constant;
import validate.Validation;

/**
 *
 * @author nguye
 */
public class Student {
    
    private String id;
    private String name;
    private String semester;
    private String course;
    
    public Student() {
        
    }

    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public void input() {
        id = Validation.getString("Enter student's ID: ",
                "ID is invalid (Correct form is HExxxxxx or HSxxxxxx)",
                Constant.ID_FORM);
        name = Validation.getString("Enter student's name: ",
                "Name is invalid (Name cannot contain number or special character)",
                Constant.NAME_FORM);
        semester = Validation.getString("Enter student's semester: ",
                "Semester is invalid (Correct form is (season+year))",
                Constant.SEMESTER_FORM);
        course = Validation.getString("Enter student's course: ",
                "Course is invalid (Correct course is in (Java,C/C++,.Net) )",
                Constant.COURSE_FORM);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + '}';
    }
    
    public void display() {
        System.out.println(name+"\t\t"+semester+"\t"+course+"\t");
    }
}
