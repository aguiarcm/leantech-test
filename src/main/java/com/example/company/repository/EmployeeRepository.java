package com.example.company.repository;

import com.example.company.entity.Employee;
import com.example.company.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByPosition(Position position);
    List<Employee> findByPersonFirstName(String firstName);
}
