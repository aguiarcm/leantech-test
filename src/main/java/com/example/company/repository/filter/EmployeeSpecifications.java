package com.example.company.repository.filter;

import com.example.company.entity.*;
import com.example.company.searchcriteria.EmployeeSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.util.Locale;
import java.util.Optional;

public final class EmployeeSpecifications {

    private EmployeeSpecifications() {
    }

    public static Specification<Employee> createEmployeeSpec(EmployeeSearchCriteria searchCriteria) {
        return matchFirstName(searchCriteria.getName())
                .or(matchPosition(searchCriteria.getPositionName()));
    }

    public static Specification<Employee> matchFirstName(Optional<String> name) {
       return (root, query, builder) -> {
            Join<Employee, Person> personJoin = root.join(Employee_.person);
            return name.map(firstName ->
                    builder
                            .like(builder
                                    .lower(personJoin.get(Person_.firstName)),
                                    "%" + String.valueOf(firstName).trim().toLowerCase(Locale.ROOT) + "%")
            ).orElse(null);
        };
    }


    public static Specification<Employee> matchPosition(Optional<String> positionName) {
        return (root, query, builder) -> {
            Join<Employee, Position> positionJoin = root.join(Employee_.position);
            return positionName.map(role -> builder
                    .like(builder.lower(positionJoin.get(Position_.name)),
                            "%" + String.valueOf(role).trim().toLowerCase(Locale.ROOT) + "%")
            ).orElse(null);
        };
    }
}
