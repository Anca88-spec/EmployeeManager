package org.example;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DatabaseTest {

    @BeforeEach
    void cleanTable() throws Exception {
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM employees");
        }
    }

    @Test
    @Order(1)
    void testAddEmployee() {
        Employee emp = new Employee("Maria", "maria@gmail.com", 4000);
        Database.addEmployee(emp);

        List<Employee> employees = Database.getAllEmployees();
        assertEquals(1, employees.size());
        assertEquals("Maria", employees.get(0).getName());
    }

    @Test
    @Order(2)
    void testGetAllEmployees() {
        Database.addEmployee(new Employee("Flavia", "flavia@gmail.com", 3000));
        Database.addEmployee(new Employee("Paul", "paul@yahoo.com", 2500));

        List<Employee> employees = Database.getAllEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    @Order(3)
    void testDeleteEmployee() {
        Database.addEmployee(new Employee("Paul", "paul@yahoo.com", 2500));

        int id = Database.getAllEmployees().get(0).getId();
        Database.deleteEmployee(id);

        assertEquals(0, Database.getAllEmployees().size());
    }
}
