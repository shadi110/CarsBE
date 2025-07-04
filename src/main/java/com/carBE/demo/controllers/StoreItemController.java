package com.carBE.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carBE.demo.Services.StoreItemService;
import com.carBE.demo.dto.StoreItem;

import java.util.List;

@RestController
@RequestMapping("/api/store-items")
public class StoreItemController {

    @Autowired
    private StoreItemService storeItemService;

    @PostMapping
    public ResponseEntity<StoreItem> createStoreItem(@RequestBody StoreItem storeItem) {
        StoreItem createdItem = storeItemService.createStoreItem(storeItem);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreItem> getStoreItemById(@PathVariable Long id) {
        StoreItem storeItem = storeItemService.getStoreItemById(id);
        return ResponseEntity.ok(storeItem);
    }

    @GetMapping
    public ResponseEntity<List<StoreItem>> getAllStoreItems() {
        List<StoreItem> storeItems = storeItemService.getAllStoreItems();
        return ResponseEntity.ok(storeItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreItem> updateStoreItem(@PathVariable Long id, @RequestBody StoreItem storeItem) {
        StoreItem updatedItem = storeItemService.updateStoreItem(id, storeItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreItem(@PathVariable Long id) {
        storeItemService.deleteStoreItem(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/store/{storeId}")
    public ResponseEntity<List<StoreItem>> getStoreItemsByStore(@PathVariable Long storeId) {
        List<StoreItem> storeItems = storeItemService.getStoreItemsByStore(storeId);
        return ResponseEntity.ok(storeItems);
    }*/
}