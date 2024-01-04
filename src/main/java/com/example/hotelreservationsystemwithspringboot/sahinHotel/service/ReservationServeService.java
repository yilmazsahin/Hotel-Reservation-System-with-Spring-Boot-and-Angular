package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Reservation;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.ReservationServe;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Serve;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.ReservationServeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class ReservationServeService {
    private final ReservationServeRepository reservationServeRepository;

    public ReservationServeService(ReservationServeRepository reservationServeRepository) {
        this.reservationServeRepository = reservationServeRepository;
    }

    public List<ReservationServe> getAllReservationServes() {
        return reservationServeRepository.findAll();
    }

    public ReservationServe getReservationServiceById(Long id) {
        return reservationServeRepository.findById(id).orElse(null);
    }

    public ReservationServe saveReservationServe(ReservationServe reservationServe) {
        return reservationServeRepository.save(reservationServe);
    }

    public void deleteReservationServById(Long id) {
        reservationServeRepository.deleteById(id);
    }

    public ReservationServe updateReservationServe(Long id, ReservationServe updatedReservationServe) {
        ReservationServe existingReservationServe = reservationServeRepository.findById(id).orElseThrow(() -> new RuntimeException("ReservationService not found with id: " + id));
        existingReservationServe.setReservation(updatedReservationServe.getReservation());
        existingReservationServe.setService(updatedReservationServe.getService());
        existingReservationServe.setServiceName(updatedReservationServe.getServiceName());
        existingReservationServe.setServicePrice(updatedReservationServe.getServicePrice());
        existingReservationServe.setServiceQuantity(updatedReservationServe.getServiceQuantity());
        existingReservationServe.setTotalPrice(updatedReservationServe.getTotalPrice());
        return reservationServeRepository.save(existingReservationServe);
    }

    public ReservationServe partialUpdateReservationServe(Long id, Map<String, Object> updates) {
        ReservationServe existingReservationService = reservationServeRepository.findById(id).orElseThrow(() -> new RuntimeException("ReservationService not found with id: " + id));
        if (updates.containsKey("reservation")) {
            existingReservationService.setReservation((Reservation) updates.get("reservation"));
        }
        if (updates.containsKey("serviceName")) {
            existingReservationService.setServiceName((String) updates.get("serviceName"));
        }
        if (updates.containsKey("servicePrice")) {
            existingReservationService.setServicePrice((double) updates.get("servicePrice"));
        }
        if (updates.containsKey("serviceQuantity")) {
            existingReservationService.setServiceQuantity((int) updates.get("serviceQuantity"));
        }
        if (updates.containsKey("service")) {
            existingReservationService.setService((Serve) updates.get("service"));
        }
        if (updates.containsKey("totalPrice")) {
            existingReservationService.setTotalPrice((double) updates.get("totalPrice"));
        }
        return reservationServeRepository.save(existingReservationService);
    }
}
