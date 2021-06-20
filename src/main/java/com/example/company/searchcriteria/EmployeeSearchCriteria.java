package com.example.company.searchcriteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Builder
public class EmployeeSearchCriteria {

    private Optional<String> name;
    private Optional<String> positionName;
}
