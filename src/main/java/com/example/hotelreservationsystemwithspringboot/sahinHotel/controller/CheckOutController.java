package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.CheckOut;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.CheckOutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yilmazsahin
 * @since 1/5/2024
 */
@RestController
@RequestMapping("/api/checkouts")

public class CheckOutController {
    private final CheckOutService checkOutService;
    public CheckOutController(CheckOutService checkOutService){
        this.checkOutService=checkOutService;
    }

}
