package com.example.company.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public class Person_ {
    public static volatile SingularAttribute<Person, String> firstName;
}
