package org.example.service.impl;

import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    private static final int ID = 1;
    private static final String NAME = "ABC";
    private static final String DESIGNATION = "IT";
    private static final Double SALARY = 5555.55;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setEmployeeId(ID);
        employee.setEmployeeName(NAME);
        employee.setDesignation(DESIGNATION);
        employee.setSalary(SALARY);
    }

    @Test
    void findById() {
        Mockito.when(employeeRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(employee));
        Employee emp = employeeService.findById(ID);
        Assertions.assertNotNull(emp);
        Assertions.assertEquals(ID, emp.getEmployeeId());
        Assertions.assertEquals(SALARY, emp.getSalary());
    }

    @Test
    void findByEmployeeName() {
        Mockito.when(employeeRepository.findByEmployeeName(ArgumentMatchers.anyString())).thenReturn(Optional.of(employee));
        Employee emp = employeeService.findByEmployeeName(NAME);
        Assertions.assertNotNull(emp);
        Assertions.assertEquals(NAME, emp.getEmployeeName());
        Assertions.assertEquals(SALARY, emp.getSalary());
    }

    @Test
    void findByDesignation() {
        Mockito.when(employeeRepository.findByDesignation(ArgumentMatchers.anyString())).thenReturn(Optional.of(Collections.singletonList(employee)));
        List<Employee> employees = employeeService.findByDesignation(DESIGNATION);
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
        Assertions.assertEquals(DESIGNATION, employees.get(0).getDesignation());
    }

    @Test
    void findAllEmployees() {
        Mockito.when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));
        List<Employee> employees = employeeService.findAllEmployees();
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
    }

    @Test
    void saveOrUpdate() {
        Mockito.when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
        Employee emp = employeeService.saveOrUpdate(this.employee);
        Assertions.assertNotNull(emp);
        Assertions.assertEquals(ID, emp.getEmployeeId());
        Assertions.assertEquals(SALARY, emp.getSalary());
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(employeeRepository).deleteById(ArgumentMatchers.anyInt());
        employeeService.deleteById(ID);
        Mockito.verify(employeeRepository).deleteById(ArgumentMatchers.anyInt());
    }
}