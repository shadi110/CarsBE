package com.carBE.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String city;
    private String logoImage;
    private String contactInfo;
    private String phoneNumber;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;
    
    @ElementCollection
    private List<Long> favoritesList;
    
    @ElementCollection
    private List<Long> savedItemsList;
    
    @ElementCollection
    private List<String> reelsLinksList;
}