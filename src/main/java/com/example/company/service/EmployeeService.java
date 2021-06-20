package com.example.company.service;


import com.example.company.entity.Employee;
import com.example.company.repository.EmployeeRepository;
import com.example.company.repository.filter.EmployeeSpecifications;
import com.example.company.searchcriteria.EmployeeSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Saves or update given employee
     * @param e
     * @param id
     * @return
     */
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

    /**
     * Search for employees matching criteria. Can be null for returning all.
     * @param employeeSearchCriteria
     * @return
     */
    public List<Employee> findAll(EmployeeSearchCriteria employeeSearchCriteria) {
        Specification<Employee> employeeSpecification = EmployeeSpecifications.createEmployeeSpec(employeeSearchCriteria);
        return employeeRepository.findAll(employeeSpecification);
    }
}
