package com.carBE.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carBE.demo.dto.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}