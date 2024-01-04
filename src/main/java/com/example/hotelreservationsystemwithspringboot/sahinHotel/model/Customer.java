package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "description")
    private String description;

}
