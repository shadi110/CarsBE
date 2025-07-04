package com.carBE.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "store_items")
public class StoreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private double price;
    private String description;
    
    @ElementCollection
    private List<String> images;
    
    @ElementCollection
    private List<String> videos;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}