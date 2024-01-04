package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.ReservationServe;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Serve;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.ReservationServeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@RestController
@RequestMapping("/api/reservation_services")
public class ReservationServeController {
    private final ReservationServeService reservationServeService;

    public ReservationServeController(ReservationServeService reservationServeService) {
        this.reservationServeService = reservationServeService;
    }

    @GetMapping
    public List<ReservationServe> getAllReservationsServes() {
        return reservationServeService.getAllReservationServes();
    }

    @GetMapping( "/{id}")
    public ReservationServe getReservationServeById(@PathVariable Long id) {
        return reservationServeService.getReservationServiceById(id);
    }

    @PostMapping
    public ReservationServe saveReservationServe(@RequestBody ReservationServe reservationServe) {
        return reservationServeService.saveReservationServe(reservationServe);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationServeById(Long id) {
        reservationServeService.deleteReservationServById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationServe> updateReservationServe(@PathVariable Long id, @RequestBody ReservationServe updatedReservationServe) {
        ReservationServe result = reservationServeService.updateReservationServe(id, updatedReservationServe);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
