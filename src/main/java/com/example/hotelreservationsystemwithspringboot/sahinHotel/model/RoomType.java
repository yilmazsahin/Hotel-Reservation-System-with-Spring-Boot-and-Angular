package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import lombok.Data;
import jakarta.persistence.*;
import lombok.extern.java.Log;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */
@Data
@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_type_name")
    private String typeName;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
}
