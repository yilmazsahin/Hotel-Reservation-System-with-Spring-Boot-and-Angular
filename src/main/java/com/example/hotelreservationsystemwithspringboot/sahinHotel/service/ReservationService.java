package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Customer;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Reservation;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Room;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationByCustomerName(String customerName) {
        return reservationRepository.findByCustomerName(customerName);
    }

    public List<Reservation> getReservationsByDateRange(LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByCheckInDateBetweenAndCheckOutDateBetween(startDate, endDate,null,null);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        existingReservation.setRoom(updatedReservation.getRoom());
        existingReservation.setCustomer(updatedReservation.getCustomer());
        existingReservation.setCheckInDate(updatedReservation.getCheckInDate());
        existingReservation.setCheckOutDate(updatedReservation.getCheckOutDate());
        existingReservation.setCheckedInDate(updatedReservation.getCheckedInDate());
        existingReservation.setCheckedOutDate(updatedReservation.getCheckedOutDate());
        return reservationRepository.save(existingReservation);
    }

    public Reservation partialUpdateReservation(Long id, Map<String, Object> updates) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));

        if (updates.containsKey("room")) {
            existingReservation.setRoom((Room) updates.get("room"));
        }
        if (updates.containsKey("customer")) {
            existingReservation.setCustomer((Customer) updates.get("customer"));
        }
        if (updates.containsKey("customerName")) {
            existingReservation.setCustomerName((String) updates.get("customerName"));
        }
        if (updates.containsKey("checkInDate")) {
            existingReservation.setCheckInDate((LocalDate) updates.get("checkInDate"));
        }
        if (updates.containsKey("checkOutDate")) {
            existingReservation.setCheckOutDate((LocalDate) updates.get("checkOutDate"));
        }
        if (updates.containsKey("checkedInDate")) {
            existingReservation.setCheckedInDate((LocalDate) updates.get("checkedInDate"));
        }
        if (updates.containsKey("checkedOutDate")) {
            existingReservation.setCheckedOutDate((LocalDate) updates.get("checkedOutDate"));
        }
        return reservationRepository.save(existingReservation);
    }
}
