package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Employee Manager ===");
            System.out.println("1. Add employee");
            System.out.println("2. Employee list");
            System.out.println("3. Delete employee");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    Employee emp = new Employee(name, email, salary);
                    Database.addEmployee(emp);
                }
                case 2 -> {
                    var list = Database.getAllEmployees();
                    if (list.isEmpty()) {
                        System.out.println("No employee registered.");
                    } else {
                        System.out.println("\n-- Employee List --");
                        list.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("ID for delete: ");
                    int id = sc.nextInt();
                    Database.deleteEmployee(id);
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
