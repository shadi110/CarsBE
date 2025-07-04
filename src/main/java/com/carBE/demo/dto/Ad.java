package com.carBE.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String image;
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "car_agency_id")
    private CarAgency carAgency;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}