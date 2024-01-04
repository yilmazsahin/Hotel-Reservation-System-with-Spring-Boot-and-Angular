package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
