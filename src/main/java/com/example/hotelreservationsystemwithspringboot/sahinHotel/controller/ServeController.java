package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Serve;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.ServeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@RestController
@RequestMapping(name = "/api/services")
public class ServeController {
    private final ServeService serveService;

    public ServeController(ServeService serveService) {
        this.serveService = serveService;
    }

    @GetMapping
    public List<Serve> getAllServices() {
        return serveService.getAllServices();
    }

    @GetMapping("/{}id")
    public Serve getServiceById(Long id) {
        return serveService.getServiceById(id);
    }

    @PostMapping
    public Serve saveService(Serve service) {
        return serveService.saveService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceById(Long id) {
        serveService.deleteServiceById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serve> updateServe(@PathVariable Long id, @RequestBody Serve updatedServe) {
        Serve result = serveService.updateServe(id, updatedServe);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Serve> partialUpdateServe(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Serve result = serveService.partialUpdateServe(id, updates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
