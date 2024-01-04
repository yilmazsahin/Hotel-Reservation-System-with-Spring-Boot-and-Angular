package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Data
@Entity
@Table(name = "services")
public class Serve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_price")
    private double price;

}
