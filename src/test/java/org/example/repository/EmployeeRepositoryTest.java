package org.example.repository;

import org.example.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findByEmployeeName() {
        Optional<Employee> employeeName = employeeRepository.findByEmployeeName("ABC");
        Assertions.assertNotNull(employeeName);
        Assertions.assertTrue(employeeName.isPresent());
        employeeName.ifPresent(employee -> Assertions.assertEquals("ABC", employee.getEmployeeName()));
    }

    @Test
    void findByDesignation() {
        Optional<List<Employee>> employees = employeeRepository.findByDesignation("IT");
        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.isPresent());
        employees.ifPresent(employee -> {
            Assertions.assertFalse(employee.isEmpty());
            Assertions.assertEquals("IT", employee.get(0).getDesignation());
        });
    }
}