package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.Store;

public interface StoreService {
    Store createStore(Store store);
    Store getStoreById(Long id);
    List<Store> getAllStores();
    Store updateStore(Long id, Store store);
}