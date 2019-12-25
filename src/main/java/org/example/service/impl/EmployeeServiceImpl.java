package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee findByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName).orElse(null);
    }

    @Override
    public List<Employee> findByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation).orElseGet(ArrayList::new);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
