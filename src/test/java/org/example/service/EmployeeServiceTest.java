package org.example.service;

import org.example.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeServiceTest {

    private static final int ID = 1;
    private static final String NAME = "ABC";
    private static final String DESIGNATION = "IT";

    @Autowired
    EmployeeService employeeService;

    @Test
    void findById() {
        Employee employee = employeeService.findById(ID);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(ID, employee.getEmployeeId());
    }

    @Test
    void findByEmployeeName() {
        Employee employee = employeeService.findByEmployeeName(NAME);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(NAME, employee.getEmployeeName());
    }

    @Test
    void findByDesignation() {
        List<Employee> employees = employeeService.findByDesignation(DESIGNATION);
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
        Assertions.assertEquals(DESIGNATION, employees.get(0).getDesignation());
    }

    @Test
    void findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
    }

    @Test
    void saveOrUpdate() {
        Employee employee = new Employee();
        employee.setEmployeeName("PQR");
        employee.setDesignation("IT");
        employee.setSalary(5555.55);
        Employee emp = employeeService.saveOrUpdate(employee);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("PQR", emp.getEmployeeName());
    }

    @Test
    void deleteById() {
        employeeService.deleteById(ID);
        Assertions.assertTrue(true);
    }
}