package com.example.company.entity;



import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long employeeId;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    @JoinColumn(name="personId")
    private Person person;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Position.class)
    @JoinColumn(name="positionId")
    private Position position;
    private double salary;

    protected Employee() {}

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long geEmployeeId() {
        return employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public Position getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

}
