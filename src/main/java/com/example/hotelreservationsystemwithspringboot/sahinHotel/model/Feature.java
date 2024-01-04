package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */
@Data
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "feature_name")
    private String featureName;
    @Column(name = "description")
    private String description;


}
