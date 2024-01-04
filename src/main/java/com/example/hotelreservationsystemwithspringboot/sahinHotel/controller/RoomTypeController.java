package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.RoomType;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/room_types")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    @GetMapping("/{id}")
    public RoomType getRoomTypeById(@PathVariable Long id) {
        return roomTypeService.getRoomTypeById(id);
    }

    @PostMapping
    public RoomType saveRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.saveRoomType(roomType);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomType(@PathVariable Long id) {
        roomTypeService.deleteRoomType(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable Long id, @RequestBody RoomType updateRoomType) {
        RoomType result = roomTypeService.updateRoomType(id, updateRoomType);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoomType> partialUpdateRoomType(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        RoomType result = roomTypeService.partialUpdateRoomType(id, updates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
