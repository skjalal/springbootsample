package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Employee;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("employees/byName/{name}")
    public Employee findByName(@PathVariable("name") String name) {
        return employeeService.findByEmployeeName(name);
    }

    @GetMapping("employees/byDesignation/{designation}")
    public List<Employee> findByDesignation(@PathVariable("designation") String designation) {
        return employeeService.findByDesignation(designation);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @PutMapping("employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
