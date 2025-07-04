package com.carBE.demo.dto;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
@Table(name = "car_agencies")
public class CarAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String city;
    private String logoImage;
    private String contactInfo;
    
    @OneToMany(mappedBy = "carAgency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;
    
    @OneToMany(mappedBy = "carAgency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ad> ads;
}