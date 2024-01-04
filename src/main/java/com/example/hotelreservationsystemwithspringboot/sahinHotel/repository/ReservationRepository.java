package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerName(String CustomerName);
    List<Reservation> findByCheckInDateBetweenAndCheckOutDateBetween(  LocalDate start1, LocalDate end1,
                                                                       LocalDate start2, LocalDate end2);
}
