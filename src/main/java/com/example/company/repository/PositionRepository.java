package com.example.company.repository;

import com.example.company.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("Select distinct(p) from Position p left join fetch p.employees e order by e.salary ASC")
    List<Position> findPositionsAndEmployeesOrderBySalaryAsc();
}
