package com.example.company.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Position.class)
public class Position_ {
    public static volatile SingularAttribute<Position, String> name;
}
