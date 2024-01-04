package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Data
@Entity
@Table(name = "reservation_services")
public class ReservationServe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Serve service;

    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "service_price")
    private double servicePrice;
    @Column(name = "service_quantity")
    private int serviceQuantity;
    @Column(name = "total_price")
    private double totalPrice;
}
