package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class Database {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try (InputStream input = Database.class.getResourceAsStream("/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            URL = prop.getProperty("spring.datasource.url");
            USER = prop.getProperty("spring.datasource.username");
            PASSWORD = prop.getProperty("spring.datasource.password");
        } catch (Exception e) {
            System.out.println("Error loading database configuration: " + e.getMessage());
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees(name, email, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding: " + e.getMessage());
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY id";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Listing error: " + e.getMessage());
        }
        return list;
    }

    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee with the given ID does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting: " + e.getMessage());
        }
    }
}

