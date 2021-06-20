package com.example.company;


import com.example.company.entity.Employee;
import com.example.company.entity.Person;
import com.example.company.entity.Position;
import com.example.company.searchcriteria.EmployeeSearchCriteria;
import com.example.company.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyApplicationTests {

	private static final double SALARY_TEST = 3500d;
	private static final String NAME_TEST = "Carlos";

	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
	}

	@Test
	void employeeService_findAllTest() {
		EmployeeSearchCriteria employeeSearchCriteria = EmployeeSearchCriteria.builder()
				.name(Optional.empty())
				.positionName(Optional.empty())
				.build();

		List<Employee> employeeList =  employeeService.findAll(employeeSearchCriteria);
		assertFalse(employeeList.isEmpty());
	}

	@Test
	void employeeService_findAllEmployeesMatchingNameOrPositionTest() {
		EmployeeSearchCriteria employeeSearchCriteria = EmployeeSearchCriteria.builder()
				.name(Optional.of("----"))
				.positionName(Optional.empty())
				.build();

		List<Employee> employeeList =  employeeService.findAll(employeeSearchCriteria);
		assertTrue(employeeList.isEmpty());
	}

	@Test
	void employeeService_addNewEmployeeTest() {
		Person p = new Person(NAME_TEST,null, null, null, null);
		Position pos = new Position(1l); // existing
		Employee employee = new Employee(p, pos, SALARY_TEST);
		assertNotNull(employeeService.update(employee, -1l));
	}

	@Test
	void employeeService_updateEmployeeTest() {
		//This employee was loaded in start up. See LoadDatabase.java
		EmployeeSearchCriteria employeeSearchCriteria = EmployeeSearchCriteria.builder()
				.name(Optional.of("Simon"))
				.positionName(Optional.empty())
				.build();
		List<Employee> employees = employeeService.findAll(employeeSearchCriteria);
		assertTrue(employees.size() > 0);

		Employee simon = employees.get(0);
		simon.setSalary(SALARY_TEST);
		simon = employeeService.update(simon, -1l);
		assertNotNull(simon);

		assertTrue(simon.getSalary() == SALARY_TEST);
	}



}
