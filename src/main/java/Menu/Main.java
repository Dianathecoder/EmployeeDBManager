/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;


import GestionBBDD.GestionBBDD;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        GestionBBDD manager = new GestionBBDD();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Delete Employee");
            System.out.println("4) List Employees");
            System.out.println("5) Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    boolean addMore = true;
                    while (addMore) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter flat: ");
                        String flat = sc.nextLine();

                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine(); // consume newline

                        manager.addEmployee(id, name, age, flat, salary);

                        System.out.println("1) Add another employee\n2) Return to main menu");
                        int response = sc.nextInt();
                        sc.nextLine(); // consume newline
                        addMore = response == 1;
                    }
                    break;
                    case 2:
                      
                       System.out.print("Enter the ID of the employee to update: ");
                       int updateId = sc.nextInt();
                       sc.nextLine(); 

                       System.out.print("Enter new name: ");
                       String newName = sc.nextLine();

                       System.out.print("Enter new age: ");
                       int newAge = sc.nextInt();
                        sc.nextLine();

                       System.out.print("Enter new flat: ");
                       String newFlat = sc.nextLine();

                       System.out.print("Enter new salary: ");
                       double newSalary = sc.nextDouble();
                       sc.nextLine();

                       manager.updateEmployee(updateId, newName, newAge, newFlat, newSalary);
                       System.out.println("Employee updated successfully.");

    
                        break;

 

                case 3:
                    System.out.print("Enter the ID of the employee to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    manager.deleteEmployee(deleteId);
                    break;

                case 4:
                    manager.listEmployees();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 5);

        sc.close();
    }
}

