package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.StoreRepository;
import com.carBE.demo.dto.Store;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store updateStore(Long id, Store store) {
        Store existingStore = storeRepository.findById(id).orElse(null);
        if (existingStore != null) {
            existingStore.setName(store.getName());
            existingStore.setCity(store.getCity());
            existingStore.setLogoImage(store.getLogoImage());
            existingStore.setContactInfo(store.getContactInfo());
            return storeRepository.save(existingStore);
        }
        return null;
    }

    /*@Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }*/
}