package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.StoreItem;

public interface StoreItemService {
    StoreItem createStoreItem(StoreItem storeItem);
    StoreItem getStoreItemById(Long id);
    List<StoreItem> getAllStoreItems();
    StoreItem updateStoreItem(Long id, StoreItem storeItem);
    void deleteStoreItem(Long id);
    //List<StoreItem> getStoreItemsByStore(Long storeId);
}