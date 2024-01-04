package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.RoomType;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }

    public RoomType updateRoomType(Long id, RoomType updatedRoomType) {
        RoomType existingRoomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomType not found with id: " + id));
        existingRoomType.setTypeName(updatedRoomType.getTypeName());
        existingRoomType.setDescription(updatedRoomType.getDescription());
        existingRoomType.setPrice(updatedRoomType.getPrice());
        return roomTypeRepository.save(existingRoomType);
    }

    public RoomType partialUpdateRoomType(Long id, Map<String, Object> updates) {
        RoomType existingRoomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("RoomType not found with id: " + id));
        if (updates.containsKey("typeName")) {
            existingRoomType.setTypeName((String) updates.get("typeName"));
        }
        if (updates.containsKey("price")) {
            existingRoomType.setPrice((double) updates.get("price"));
        }
        if (updates.containsKey("description")) {
            existingRoomType.setDescription((String) updates.get("description"));
        }
        return roomTypeRepository.save(existingRoomType);
    }
}
