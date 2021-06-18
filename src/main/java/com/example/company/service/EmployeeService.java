package com.example.company.service;


import com.example.company.entity.Employee;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee update(Employee e, Long id) {
        /*mployeeRepository.findById(id)
                .map(employee -> {
                    employee.set(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeService.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeService.save(newEmployee);
                });*/
        return null;
    }
}
