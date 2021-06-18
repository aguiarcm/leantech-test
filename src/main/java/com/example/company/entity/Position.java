package com.example.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long positionId;
    private String name;

    protected Position() {}

    public Position(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Position[positionId=%d, name='%s']", positionId, name);
    }
}
