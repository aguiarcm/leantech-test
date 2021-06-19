package com.example.company.service;


import com.example.company.entity.Employee;
import com.example.company.entity.Position;
import com.example.company.repository.EmployeeRepository;
import com.example.company.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Transactional
    public Position save(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public List<Position> findOrderByEmployeeSalaryASC() {
        return positionRepository
                .findPositionsAndEmployeesOrderBySalaryAsc();
    }

}
