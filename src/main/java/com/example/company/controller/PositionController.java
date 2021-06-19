package com.example.company.controller;

import com.example.company.entity.Position;
import com.example.company.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    @Autowired
    private PositionService positionService;


    @GetMapping("/positions")
    Iterable<Position> findAll() {
        return positionService.findAll();
    }

    @GetMapping("/positions/bySalary")
    Iterable<Position> findBySalary() {
        return positionService.findOrderByEmployeeSalaryASC();
    }

    @PostMapping("/positions")
    Position add(@RequestBody Position position) {
        return positionService.save(position);
    }

}
