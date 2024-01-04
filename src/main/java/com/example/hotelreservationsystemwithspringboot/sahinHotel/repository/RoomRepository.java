package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */

public interface RoomRepository extends JpaRepository<Room, Long> {
}
