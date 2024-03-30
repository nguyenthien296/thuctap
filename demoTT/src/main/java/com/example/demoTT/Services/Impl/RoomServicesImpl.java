package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Cinema;
import com.example.demoTT.Models.Room;
import com.example.demoTT.Repository.CinemaRepo;
import com.example.demoTT.Repository.RoomRepo;
import com.example.demoTT.Services.CinemaServices;
import com.example.demoTT.Services.RoomServices;
import com.example.demoTT.dto.Request.RoomRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RoomServicesImpl implements RoomServices {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private CinemaRepo cinemaRepo;

    @Override
    public MessageResponse createRoom(RoomRequest roomRequest) {
        Cinema cinema = cinemaRepo.findById(roomRequest.getCinemaId()).orElse(null);
        if (cinema == null){
            return MessageResponse.builder().message("Cinema không tồn tại").build();
        }
        Room newRoom = Room.builder()
                .name(roomRequest.getName())

                .type(roomRequest.getType())
                .cinema(cinema)
                .isActive(true)
                .description(roomRequest.getDescription())
                .capacity(roomRequest.getCapacity())
                .build();
        roomRepo.save(newRoom);
        return MessageResponse.builder().message("Thêm room thành công").build();
    }

    @Override
    public MessageResponse updateRoom(RoomRequest roomRequest, int id) {
        Optional<Room> roomOptional = roomRepo.findById(id);
        Cinema cinema = cinemaRepo.findById(roomRequest.getCinemaId()).orElse(null);
        if(cinema ==null){
            return MessageResponse.builder().message("Cinema không tồn tại").build();
        }
        if (roomOptional.isEmpty()) {
            return MessageResponse.builder().message("Room không tồn tại").build();
        }
        Room room = roomOptional.get();
        room.setCinema(cinema);
        room.setDescription(roomRequest.getDescription());
        room.setType(roomRequest.getType());
        room.setCapacity(roomRequest.getCapacity());
        room.setName(roomRequest.getName());
        roomRepo.save(room);
        return MessageResponse.builder().message("Update lại room thành công").build();
    }

    @Override
    public Room deleteRoom(int id) {
        Optional<Room> optionalRoom = roomRepo.findById(id);
        if (optionalRoom.isEmpty()){
            return null;
        }else {
            roomRepo.delete(optionalRoom.get());
        }
        return optionalRoom.get();
    }
}
