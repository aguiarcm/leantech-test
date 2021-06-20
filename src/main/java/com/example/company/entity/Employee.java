package com.example.company.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long employeeId;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    @JoinColumn(name="personId")
    private Person person;
    @JsonIgnoreProperties("employees")
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Position.class)
    @JoinColumn(name="positionId")
    private Position position;
    private double salary;

    public Employee() {}

    public Employee(Person person, Position position, double salary ) {
        super();
        this.person = person;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Person person, Position position) {
        this.person = person;
        this.position = position;
    }
}
