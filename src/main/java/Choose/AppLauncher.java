/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Choose;

import java.util.Scanner;

public class AppLauncher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose interface: 1) GUI  2) Console");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1) {
            java.awt.EventQueue.invokeLater(() -> {
                new Views.EmployeeMenu().setVisible(true);
            });
        } else {
            try {
                Menu.Main.main(args);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
