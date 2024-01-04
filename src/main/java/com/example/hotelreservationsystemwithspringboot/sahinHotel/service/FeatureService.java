package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Feature;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id).orElse(null);
    }

    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    public void deleteFeatureById(Long id) {
        featureRepository.deleteById(id);
    }

    public Feature updateFeature(Long id, Feature updatedFeature) {
        Feature existingFeature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found with id : " + id));
        existingFeature.setFeatureName(updatedFeature.getFeatureName());
        existingFeature.setDescription(updatedFeature.getDescription());
        return featureRepository.save(existingFeature);
    }

    public Feature partialUpdateFeature(Long id, Map<String, Object> updates) {
        Feature existingFeature = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found with id : " + id));
        if (updates.containsKey("featureName")) {
            existingFeature.setFeatureName((String) updates.get("fullName"));
        }
        if (updates.containsKey("description")) {
            existingFeature.setDescription((String) updates.get("description"));
        }
        return featureRepository.save(existingFeature);
    }
}
