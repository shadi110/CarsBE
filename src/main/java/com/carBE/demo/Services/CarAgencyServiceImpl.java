package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.CarAgencyRepository;
import com.carBE.demo.dto.CarAgency;

import java.util.List;

@Service
public class CarAgencyServiceImpl implements CarAgencyService {

    @Autowired
    private CarAgencyRepository carAgencyRepository;

    @Override
    public CarAgency createCarAgency(CarAgency carAgency) {
        return carAgencyRepository.save(carAgency);
    }

    @Override
    public CarAgency getCarAgencyById(Long id) {
        return carAgencyRepository.findById(id).orElse(null);
    }

    @Override
    public List<CarAgency> getAllCarAgencies() {
        return carAgencyRepository.findAll();
    }

    @Override
    public CarAgency updateCarAgency(Long id, CarAgency carAgency) {
        CarAgency existingAgency = carAgencyRepository.findById(id).orElse(null);
        if (existingAgency != null) {
            existingAgency.setName(carAgency.getName());
            existingAgency.setCity(carAgency.getCity());
            existingAgency.setLogoImage(carAgency.getLogoImage());
            existingAgency.setContactInfo(carAgency.getContactInfo());
            return carAgencyRepository.save(existingAgency);
        }
        return null;
    }

    @Override
    public void deleteCarAgency(Long id) {
        carAgencyRepository.deleteById(id);
    }
}