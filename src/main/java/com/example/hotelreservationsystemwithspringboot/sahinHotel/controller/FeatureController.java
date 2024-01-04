package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Feature;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.FeatureService;
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
@RequestMapping("/api/features")
public class FeatureController {
    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @GetMapping("/{id}")
    public Feature getFeatureById(@PathVariable Long id) {
        return featureService.getFeatureById(id);
    }

    @PostMapping
    public Feature saveFeature(@RequestBody Feature feature) {
        return featureService.saveFeature(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteFeatureById(Long id) {
        featureService.deleteFeatureById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> updateFeature(@PathVariable Long id, @RequestBody Feature updatedFeature) {
        Feature result = featureService.updateFeature(id, updatedFeature);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Feature> partialUpdateFeature(@PathVariable Long id, Map<String, Object> updates) {
        Feature result = featureService.partialUpdateFeature(id, updates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
