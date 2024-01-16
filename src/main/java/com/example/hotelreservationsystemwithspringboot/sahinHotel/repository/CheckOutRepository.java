package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/5/2024
 */

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
}
