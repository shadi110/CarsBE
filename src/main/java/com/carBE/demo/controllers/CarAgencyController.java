package com.carBE.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carBE.demo.Services.CarAgencyService;
import com.carBE.demo.dto.CarAgency;

import java.util.List;

@RestController
@RequestMapping("/api/car-agencies")
public class CarAgencyController {

    @Autowired
    private CarAgencyService carAgencyService;

    @PostMapping
    public ResponseEntity<CarAgency> createCarAgency(@RequestBody CarAgency carAgency) {
        CarAgency createdAgency = carAgencyService.createCarAgency(carAgency);
        return ResponseEntity.ok(createdAgency);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarAgency> getCarAgencyById(@PathVariable Long id) {
        CarAgency carAgency = carAgencyService.getCarAgencyById(id);
        return ResponseEntity.ok(carAgency);
    }

    @GetMapping
    public ResponseEntity<List<CarAgency>> getAllCarAgencies() {
        List<CarAgency> carAgencies = carAgencyService.getAllCarAgencies();
        return ResponseEntity.ok(carAgencies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarAgency> updateCarAgency(@PathVariable Long id, @RequestBody CarAgency carAgency) {
        CarAgency updatedAgency = carAgencyService.updateCarAgency(id, carAgency);
        return ResponseEntity.ok(updatedAgency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarAgency(@PathVariable Long id) {
        carAgencyService.deleteCarAgency(id);
        return ResponseEntity.noContent().build();
    }
}