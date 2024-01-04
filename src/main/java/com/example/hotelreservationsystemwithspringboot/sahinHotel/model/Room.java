package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */
@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

}
