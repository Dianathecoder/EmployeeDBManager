package GestionBBDD;

import Employee.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Employee Database Manager
 */
public class GestionBBDD {
    private static String connectionData = "jdbc:mysql://localhost:3307/";
    private static String database = "javaDAM";
    private static String user = "root";
    private static String password = "";
    private Connection con;
    public static Scanner sc = new Scanner(System.in);

    public GestionBBDD() {
        try {
            con = DriverManager.getConnection(connectionData, user, password);
            try {
                createDatabase();
                createEmployeeTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDatabase() throws Exception {
        String query = "CREATE DATABASE IF NOT EXISTS " + database + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            con = DriverManager.getConnection(connectionData + database, user, password);
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    private void createEmployeeTable() throws Exception {
        String query = "CREATE TABLE IF NOT EXISTS Employees("
                     + "id INT PRIMARY KEY,"
                     + "name VARCHAR(50),"
                     + "age INT,"
                     + "flat VARCHAR(50),"
                     + "salary DOUBLE)";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public Employee addEmployee(int id, String name, int age, String flat, double salary) throws SQLException {
        String query = "INSERT INTO Employees(id, name, age, flat, salary) " +
                       "VALUES('" + id + "','" + name + "','" + age + "','" + flat + "','" + salary + "')";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Employee added successfully: " + name);
        } finally {
            if (stmt != null) stmt.close();
        }
        return new Employee(id, name, age, flat, salary);
    }

    public void updateEmployee(int id, String name, int age, String flat, double salary) throws SQLException {
       Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
       ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
       boolean found = false;
        while (rs.next() && !found) {
           if (rs.getInt("id") == id) {
               rs.updateString("name", name);
               rs.updateInt("age", age);
               rs.updateString("flat", flat);
               rs.updateDouble("salary", salary);
               rs.updateRow();
               found = true;
            }
        }
        if (!found) {
           throw new SQLException("No employee found with ID: " + id);
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * FROM Employees");
        boolean found = false;
        while (rs.next() && !found) {
            if (rs.getInt("id") == id) {
                rs.deleteRow();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with the specified ID.");
        }
    }

    public List<String> listEmployees() throws SQLException {
       List<String> employees = new ArrayList<>();
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

       while (rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          int age = rs.getInt("age");
          String department = rs.getString("flat");
          double salary = rs.getDouble("salary");

          employees.add(String.format("ID: %d | %s | Age: %d | Flat: %s | Salary: %.2f",
                id, name, age, department, salary));
    }

    if (employees.isEmpty()) {
        employees.add("No employees found.");
    }

    return employees;
}
    public Connection getConnection() {
       return con;
}
}
