package com.carBE.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String city;
    private String description;
    private int kms;
    private boolean isUsed;
    private boolean isSoldOut;
    private String color;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "car_agency_id")
    private CarAgency carAgency;
}