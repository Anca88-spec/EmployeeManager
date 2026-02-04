package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testConstructorAndGetters() {
        Employee emp = new Employee(1, "Silvia Pascu", "pascusilvia@gmail.com", 3000);

        assertEquals("Silvia Pascu", emp.getName());
        assertEquals("pascusilvia@gmail.com", emp.getEmail());
        assertEquals(3000, emp.getSalary());

        assertTrue(emp.toString().startsWith("1 |"));
    }

    @Test
    void testToStringFormat() {
        Employee emp = new Employee(2, "Maria Tomsa", "tomsamary@yahoo.com", 2500);
        String expected = "2 | Maria Tomsa | tomsamary@yahoo.com | 2500.0 RON";
        assertEquals(expected, emp.toString());
    }
}

