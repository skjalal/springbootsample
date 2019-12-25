package org.example.repository;

import org.example.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeName(String employeeName);
    Optional<List<Employee>> findByDesignation(String designation);
}
