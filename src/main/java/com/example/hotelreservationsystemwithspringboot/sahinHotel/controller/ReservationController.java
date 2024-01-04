package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Reservation;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservation saveReservation(Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(Long id) {
        reservationService.deleteReservationById(id);
    }

    @GetMapping("/by-customer-name")
    public List<Reservation> getReservationByCustomerName(@RequestParam String customerName) {
        return reservationService.getReservationByCustomerName(customerName);
    }

    @GetMapping("/by-date-range")
    public List<Reservation> getReservationByDateRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reservationService.getReservationsByDateRange(startDate, endDate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Reservation result = reservationService.updateReservation(id, updatedReservation);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> partialUpdateReservation(@PathVariable Long id, Map<String, Object> updates) {
        Reservation result = reservationService.partialUpdateReservation(id, updates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
