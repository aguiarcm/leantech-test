package com.example.company.service;


import com.example.company.entity.Employee;
import com.example.company.entity.Person;
import com.example.company.entity.Position;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Transactional
    public Employee update(Employee e, Long id) {
        employeeRepository.findById(id)
                .map(employee -> {
                    e.getPerson().setPersonId(employee.getPerson().getPersonId());
                    e.getPosition().setPositionId(employee.getPosition().getPositionId());
                    employee.setPerson(e.getPerson());
                    employee.setPosition(e.getPosition());
                    employee.setSalary(e.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    return employeeRepository.save(e);
                });
        return e;
    }

    public List<Employee> findEmployeesByParams(String... params) {
        //Employee e = new Employee(new Person(params[0]), new Position(params[1]));
        return employeeRepository.findAll();
    }
}
