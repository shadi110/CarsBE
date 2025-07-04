package com.carBE.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carBE.demo.Services.AdService;
import com.carBE.demo.dto.Ad;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdController {

    @Autowired
    private AdService adService;

    @PostMapping
    public ResponseEntity<Ad> createAd(@RequestBody Ad ad) {
        Ad createdAd = adService.createAd(ad);
        return ResponseEntity.ok(createdAd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable Long id) {
        Ad ad = adService.getAdById(id);
        return ResponseEntity.ok(ad);
    }

    @GetMapping
    public ResponseEntity<List<Ad>> getAllAds() {
        List<Ad> ads = adService.getAllAds();
        return ResponseEntity.ok(ads);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ad> updateAd(@PathVariable Long id, @RequestBody Ad ad) {
        Ad updatedAd = adService.updateAd(id, ad);
        return ResponseEntity.ok(updatedAd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<Ad>> getAdsByAgency(@PathVariable Long agencyId) {
        List<Ad> ads = adService.getAdsByAgency(agencyId);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Ad>> getAdsByStore(@PathVariable Long storeId) {
        List<Ad> ads = adService.getAdsByStore(storeId);
        return ResponseEntity.ok(ads);
    }*/
}