package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.StoreItemRepository;
import com.carBE.demo.StoreRepository;
import com.carBE.demo.dto.Store;
import com.carBE.demo.dto.StoreItem;

import java.util.List;

@Service
public class StoreItemServiceImpl implements StoreItemService {

    @Autowired
    private StoreItemRepository storeItemRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public StoreItem createStoreItem(StoreItem storeItem) {
        return storeItemRepository.save(storeItem);
    }

    @Override
    public StoreItem getStoreItemById(Long id) {
        return storeItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<StoreItem> getAllStoreItems() {
        return storeItemRepository.findAll();
    }

    @Override
    public StoreItem updateStoreItem(Long id, StoreItem storeItem) {
        StoreItem existingItem = storeItemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setName(storeItem.getName());
            existingItem.setPrice(storeItem.getPrice());
            existingItem.setDescription(storeItem.getDescription());
            existingItem.setImages(storeItem.getImages());
            existingItem.setVideos(storeItem.getVideos());
            return storeItemRepository.save(existingItem);
        }
        return null;
    }

    @Override
    public void deleteStoreItem(Long id) {
        storeItemRepository.deleteById(id);
    }

    /*@Override
    public List<StoreItem> getStoreItemsByStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store != null) {
            return storeItemRepository.findByStore(store);
        }
        return null;
    }*/
}