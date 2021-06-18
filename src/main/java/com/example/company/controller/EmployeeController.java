package com.example.company.controller;

import com.example.company.entity.Employee;
import com.example.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//https://spring.io/guides/tutorials/rest/
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    Employee add(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee employee, @PathVariable Long id) {

        return employeeService.update(employee, id);
    }




}
