package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.ReservationServe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */

public interface ReservationServeRepository extends JpaRepository<ReservationServe,Long> {
}
