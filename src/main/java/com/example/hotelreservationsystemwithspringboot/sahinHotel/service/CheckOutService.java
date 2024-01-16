package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.CheckOut;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.ReservationServe;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.CheckOutRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author yilmazsahin
 * @since 1/5/2024
 */
@Service
public class CheckOutService {
    private final CheckOutRepository checkOutRepository;

    public CheckOutService(CheckOutRepository checkOutRepository) {
        this.checkOutRepository = checkOutRepository;
    }

    public List<CheckOut> getAllCheckOuts() {
        return checkOutRepository.findAll();
    }

    public CheckOut getCheckOutById(Long id) {
        return checkOutRepository.findById(id).orElse(null);
    }

    public CheckOut saveCheckOut(CheckOut checkOut) {
        return checkOutRepository.save(checkOut);
    }

    public List<ReservationServe> getServicesByCheckOutId(Long checkOutId) {
        CheckOut checkOut = checkOutRepository.findById(checkOutId).orElse(null);
        if (checkOut != null) {
            return checkOut.getServices();
        }
        return Collections.emptyList();
    }
}
