package com.carBE.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carBE.demo.Services.CarService;
import com.carBE.demo.dto.Car;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.ok(createdCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updatedCar = carService.updateCar(id, car);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUser(@PathVariable Long userId) {
        List<Car> cars = carService.getCarsByUser(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<Car>> getCarsByAgency(@PathVariable Long agencyId) {
        List<Car> cars = carService.getCarsByAgency(agencyId);
        return ResponseEntity.ok(cars);
    }*/
}