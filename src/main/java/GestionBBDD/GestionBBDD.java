package Employee;

import java.sql.*;
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
                     + "department VARCHAR(50),"
                     + "salary DOUBLE)";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public Employee addEmployee(int id, String name, int age, String department, double salary) throws SQLException {
        String query = "INSERT INTO Employees(id, name, age, department, salary) " +
                       "VALUES('" + id + "','" + name + "','" + age + "','" + department + "','" + salary + "')";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Employee added successfully: " + name);
        } finally {
            if (stmt != null) stmt.close();
        }
        return new Employee(id, name, age, department, salary);
    }

    public void updateEmployee(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * FROM Employees");
        boolean found = false;
        while (rs.next() && !found) {
            if (rs.getInt("id") == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new department: ");
                String department = sc.nextLine();
                System.out.print("Enter new salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                rs.updateString("name", name);
                rs.updateInt("age", age);
                rs.updateString("department", department);
                rs.updateDouble("salary", salary);
                rs.updateRow();

                System.out.println("Employee updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with the specified ID.");
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

    public void listEmployees() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Employees");
        boolean found = false;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String department = rs.getString("department");
            double salary = rs.getDouble("salary");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + salary);
            found = true;
        }
        if (!found) {
            System.out.println("No employees found.");
        }
    }
}
