package com.example.company.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long personId;
    private String firstName;
    private String lastName;
    private String address;
    private String cellPhone;
    private String cityName;

    protected Person() {}

    /**
     * Constructor for example purposes.
     * @param firstName
     */
    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName, String address, String cellPhone, String cityName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cellPhone = cellPhone;
        this.cityName = cityName;
    }
}
