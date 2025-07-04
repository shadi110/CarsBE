package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.AdRepository;
import com.carBE.demo.CarAgencyRepository;
import com.carBE.demo.StoreRepository;
import com.carBE.demo.dto.Ad;
import com.carBE.demo.dto.CarAgency;
import com.carBE.demo.dto.Store;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;
    
    @Autowired
    private CarAgencyRepository carAgencyRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Ad createAd(Ad ad) {
        return adRepository.save(ad);
    }

    @Override
    public Ad getAdById(Long id) {
        return adRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    @Override
    public Ad updateAd(Long id, Ad ad) {
        Ad existingAd = adRepository.findById(id).orElse(null);
        if (existingAd != null) {
            existingAd.setImage(ad.getImage());
            existingAd.setDate(ad.getDate());
            return adRepository.save(existingAd);
        }
        return null;
    }

    @Override
    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }

    /*@Override
    public List<Ad> getAdsByAgency(Long agencyId) {
        CarAgency agency = carAgencyRepository.findById(agencyId).orElse(null);
        if (agency != null) {
            return adRepository.findByCarAgency(agency);
        }
        return null;
    }

    @Override
    public List<Ad> getAdsByStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store != null) {
            return adRepository.findByStore(store);
        }
        return null;
    }*/
}