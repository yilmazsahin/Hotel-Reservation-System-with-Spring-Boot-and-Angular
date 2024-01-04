package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Serve;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.ServeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class ServeService {
    private final ServeRepository servicesRepository;

    public ServeService(ServeRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Serve> getAllServices() {
        return servicesRepository.findAll();
    }

    public Serve getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    public Serve saveService(Serve service) {
        return servicesRepository.save(service);
    }

    public void deleteServiceById(Long id) {
        servicesRepository.deleteById(id);
    }

    public Serve updateServe(Long id, Serve updatedServe) {
        Serve existingServe = servicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        existingServe.setServiceName(updatedServe.getServiceName());
        existingServe.setPrice((updatedServe.getPrice()));
        return servicesRepository.save(existingServe);
    }

    public Serve partialUpdateServe(Long id, Map<String, Object> updates) {
        Serve existingServe = servicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Serve not found with id: " + id));

        if (updates.containsKey("serviceName")) {
            existingServe.setServiceName((String) updates.get("serviceName"));
        }
        if (updates.containsKey("servicePrice")) {
            existingServe.setPrice((double) updates.get("servicePrice"));
        }
        return servicesRepository.save(existingServe);

    }

}
