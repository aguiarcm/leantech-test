package com.example.company.controller;

import com.example.company.entity.Employee;
import com.example.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//https://spring.io/guides/tutorials/rest/
//https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-mvc-2/src/main/java/com/baeldung/springbootmvc
//https://spring.io/guides/gs/accessing-data-jpa/
//https://reqbin.com/req/zvtstmpb/post-request-example
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Return all employees
     * @return List of {@link Employee}
     */
    @GetMapping("/employees")
    Iterable<Employee> findAll() {
        return employeeService.findAll();
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
