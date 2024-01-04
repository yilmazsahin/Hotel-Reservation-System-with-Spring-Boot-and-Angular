package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
