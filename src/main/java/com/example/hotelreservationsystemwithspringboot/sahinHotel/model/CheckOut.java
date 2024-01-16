package com.example.hotelreservationsystemwithspringboot.sahinHotel.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author yilmazsahin
 * @since 1/5/2024
 */
@Entity
@Data
@Table(name = "checkouts")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "checked_in_date")
    private LocalDate checkInDate;

    @Column(name = "checked_out_date")
    private LocalDate checkOutDate;

    @OneToMany(mappedBy = "reservationServe",cascade = CascadeType.ALL)
    private List<ReservationServe> services;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
