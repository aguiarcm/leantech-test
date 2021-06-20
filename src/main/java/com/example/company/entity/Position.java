package com.example.company.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Position {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long positionId;
    private String name;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    protected Position() {}

    public Position(Long id) {
        this.positionId = id;
    }

    public Position(Long id, String name) {
        this.name = name;
    }
}
