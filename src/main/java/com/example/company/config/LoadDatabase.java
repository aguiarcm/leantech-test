package com.example.company.config;

import com.example.company.entity.Employee;
import com.example.company.entity.Person;
import com.example.company.entity.Position;
import com.example.company.repository.EmployeeRepository;
import com.example.company.repository.PositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, PositionRepository positionRepository) {

        return args -> {
            log.info("Preloading " + positionRepository.save(new Position(1l, "Asesor")));
            log.info("Preloading " + positionRepository.save(new Position(2l, "Ingeniero")));
            log.info("Preloading " + positionRepository.save(new Position(3l, "Maestro")));
            positionRepository.flush();
            log.info("Preloading " + repository.save(new Employee(
                    new Person("Joseph", "Ryan",
                    "15805 Biscayne Blv", "312534233", "Aventura"),
                    new Position(1l), 3000d)));
            log.info("Preloading " + repository.save(new Employee(
                    new Person("Jess", "Alvarez",
                            "Calle 7 # 81A 213", "3222531093", "Medellin"),
                    new Position(2l), 2000d)));
            log.info("Preloading " + repository.save(new Employee(
                    new Person("Simon", "Zapata",
                            "Carrera 70 # 81A 213", "3112531093", "Itagui"),
                    new Position(3l), 1500d)));

            log.info("Preloading " + repository.save(new Employee(
                    new Person("Daniel", "Cartgaena",
                            "Carrera 80 # 81A 213", "3112531093", "Itagui"),
                    new Position(1l), 1500d)));

            log.info("Preloading " + repository.save(new Employee(
                    new Person("Santiago", "Martin",
                            "Carrera 80 # 81A 213", "3112531093", "Itagui"),
                    new Position(1l), 2500d)));

        };
    }
}
