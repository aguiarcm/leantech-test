package com.example.company.controller;

import com.example.company.entity.Employee;
import com.example.company.searchcriteria.EmployeeSearchCriteria;
import com.example.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Return all employees
     * @return List of {@link Employee}
     */
    @GetMapping("/employees")
    Iterable<Employee> findAll(@RequestParam(required = false) Optional<String> name,
                               @RequestParam(required = false) Optional<String> positionName) {

        EmployeeSearchCriteria employeeSearchCriteria = EmployeeSearchCriteria.builder()
                .name(name)
                .positionName(positionName)
                .build();

        return employeeService.findAll(employeeSearchCriteria);
    }

    /**
     * saves a new employee
     * @param employee
     * @return
     */
    @PostMapping("/employees")
    Employee add(@RequestBody Employee employee) {
        return employeeService.update(employee, -1l);
    }

    /**
     * updates or creates employee info
     * @param employee
     * @param id
     * @return
     */
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.update(employee, id);
    }

}
