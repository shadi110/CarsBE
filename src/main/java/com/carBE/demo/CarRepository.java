package com.carBE.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carBE.demo.dto.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}