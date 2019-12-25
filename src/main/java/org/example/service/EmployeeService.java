package org.example.service;

import org.example.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Integer id);

    Employee findByEmployeeName(String employeeName);

    List<Employee> findByDesignation(String designation);

    List<Employee> findAllEmployees();

    Employee saveOrUpdate(Employee employee);

    void deleteById(Integer id);
}
