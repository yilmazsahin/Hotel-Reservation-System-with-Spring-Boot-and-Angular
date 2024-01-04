package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Room;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.RoomType;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.RoomRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/3/2024
 */

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found with id : " + id));
        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setRoomType(updatedRoom.getRoomType());
        existingRoom.setCapacity(updatedRoom.getCapacity());
        existingRoom.setStatus(updatedRoom.getStatus());
        return roomRepository.save(existingRoom);
    }

    public Room partialUpdateRoom(Long id, Map<String, Object> updates) {
        Room existingRoom = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found with id : " + id));
        if (updates.containsKey("roomNumber")) {
            existingRoom.setRoomNumber((int) updates.get("roomNumber"));
        }
        if (updates.containsKey("status")) {
            existingRoom.setStatus((String) updates.get("status"));
        }
        if (updates.containsKey("capacity")) {
            existingRoom.setCapacity((int) updates.get("capacity"));
        }
        if (updates.containsKey("roomType")) {
            existingRoom.setRoomType((RoomType) updates.get("roomType"));
        }
        return roomRepository.save(existingRoom);
    }

}
