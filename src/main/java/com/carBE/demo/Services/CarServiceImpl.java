package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.CarAgencyRepository;
import com.carBE.demo.CarRepository;
import com.carBE.demo.UserRepository;
import com.carBE.demo.dto.Car;
import com.carBE.demo.dto.CarAgency;
import com.carBE.demo.dto.User;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CarAgencyRepository carAgencyRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setName(car.getName());
            existingCar.setCity(car.getCity());
            existingCar.setDescription(car.getDescription());
            existingCar.setKms(car.getKms());
            existingCar.setUsed(car.isUsed());
            existingCar.setSoldOut(car.isSoldOut());
            existingCar.setColor(car.getColor());
            return carRepository.save(existingCar);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    /*@Override
    public List<Car> getCarsByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return carRepository.findByUser(user);
        }
        return null;
    }

    @Override
    public List<Car> getCarsByAgency(Long agencyId) {
        CarAgency agency = carAgencyRepository.findById(agencyId).orElse(null);
        if (agency != null) {
            return carRepository.findByCarAgency(agency);
        }
        return null;
    }*/
}