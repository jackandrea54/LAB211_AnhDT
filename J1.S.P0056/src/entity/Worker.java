package entity;

import validate.Validation;
import constant.Constant;

/**
 *
 * @author THAYCACAC
 */
public class Worker {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public void input() {
        id = Validation.getString("Enter worker's ID:",
                "Worker's ID is not valid",
                Constant.ID_FORM);
        name = Validation.getString("Enter worker's name",
                "Name can not contain number or special character",
                Constant.NAME_FORM);
        age = Validation.getInt("Enter worker's age",
                "Age is out of range", "Not a valid number",
                18, 50);
        salary = Validation.getDouble("Enter worker's salary",
                "Salary must be greater than 0",
                "Not a valid number", 0.0, Double.MAX_VALUE);
        workLocation = Validation.getString("Enter worker's location",
                "Not a location form",
                Constant.LOCATION_FORM);
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", workLocation=" + workLocation + '}';
    }

}
