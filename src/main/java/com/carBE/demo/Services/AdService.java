package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.Ad;

public interface AdService {
    Ad createAd(Ad ad);
    Ad getAdById(Long id);
    List<Ad> getAllAds();
    Ad updateAd(Long id, Ad ad);
    void deleteAd(Long id);
    //List<Ad> getAdsByAgency(Long agencyId);
    //List<Ad> getAdsByStore(Long storeId);
}