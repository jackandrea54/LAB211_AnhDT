/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Check {
    
    /**
     * check if entry of student in list of student
     * 
     * @param listStudent   a list of student 
     * @param student       a student need to check
     * @return true if in list false if not in list
     */
    public static boolean checkDuplicateEntry(ArrayList<Student> listStudent, Student student) {
        for (int i = 0; i<listStudent.size(); i++) {
            if (listStudent.get(i).getId().equals(student.getId())
                    &&listStudent.get(i).getName().equals(student.getName())
                    &&listStudent.get(i).getCourse().equals(student.getCourse())
                    &&listStudent.get(i).getSemester().equals(student.getSemester())) {
                return true;
            }
        }
        return false;
    }
    
}
