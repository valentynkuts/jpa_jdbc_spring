package com.example.demo.cars_JPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CarRepository extends CrudRepository<Car, Long> {
    Car findCarById(Long id);

    Car findCarByMarka(String marka);

    Car findCarByRegistration(String registration);

}
