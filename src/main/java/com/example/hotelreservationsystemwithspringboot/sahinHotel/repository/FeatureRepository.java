package com.example.hotelreservationsystemwithspringboot.sahinHotel.repository;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
