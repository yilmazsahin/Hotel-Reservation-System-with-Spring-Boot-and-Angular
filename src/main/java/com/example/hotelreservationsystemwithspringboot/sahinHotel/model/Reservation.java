package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */
@Entity
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "check_in_date")
    private LocalDate checkInDate;
    @Column(name = "check_out_date")
    private LocalDate checkOutDate;
    @Column(name = "checked_in_date")
    private LocalDate checkedInDate;
    @Column(name = "checked_out_date")
    private LocalDate checkedOutDate;


}
