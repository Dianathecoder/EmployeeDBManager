/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

/**
 * Employee class
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private String flat;
    private double salary;

    public Employee(int id, String name, int age, String flat, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.flat = flat;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDepartment() {
        return flat;
    }

    public void setDepartment(String department) {
        this.flat = flat;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
               ", Department: " +flat + ", Salary: " + salary;
    }
}
