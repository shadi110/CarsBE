package com.carBE.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carBE.demo.dto.StoreItem;

@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
}