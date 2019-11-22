package com.example.demo.cars_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car_jpa")
public class CarController {
    @Autowired
    CarRepository carRepository;


    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Car getCarById(@PathVariable Long id) {
        return carRepository.findCarById(id);
    }

    @GetMapping(value = "/marka/{marka}", produces = "application/json")
    public Car getCarByMarka(@PathVariable String marka) {
        return carRepository.findCarByMarka(marka);
    }

    @GetMapping(value = "/registration/{registration}", produces = "application/json")
    public Car getCarByRegistration(@PathVariable String registration) {
        return carRepository.findCarByRegistration(registration);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable Long id) {
        carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

}
