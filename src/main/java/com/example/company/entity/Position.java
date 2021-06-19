package com.example.company.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long positionId;
    private String name;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    protected Position() {}

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Position(Long id) {
        this.positionId = id;
    }

    public Position(Long id, String name) {
        this.name = name;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Position[positionId=%d, name='%s']", positionId, name);
    }
}
