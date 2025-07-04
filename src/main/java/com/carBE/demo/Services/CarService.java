package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.Car;

public interface CarService {
    Car createCar(Car car);
    Car getCarById(Long id);
    List<Car> getAllCars();
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
    //List<Car> getCarsByUser(Long userId);
    //List<Car> getCarsByAgency(Long agencyId);
}