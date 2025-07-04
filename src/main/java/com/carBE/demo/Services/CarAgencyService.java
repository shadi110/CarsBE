package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.CarAgency;

public interface CarAgencyService {
    CarAgency createCarAgency(CarAgency carAgency);
    CarAgency getCarAgencyById(Long id);
    List<CarAgency> getAllCarAgencies();
    CarAgency updateCarAgency(Long id, CarAgency carAgency);
    void deleteCarAgency(Long id);
}