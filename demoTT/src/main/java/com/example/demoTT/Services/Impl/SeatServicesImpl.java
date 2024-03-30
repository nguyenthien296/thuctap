package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Room;
import com.example.demoTT.Models.Seat;
import com.example.demoTT.Models.SeatStatus;
import com.example.demoTT.Models.SeatType;
import com.example.demoTT.Repository.RoomRepo;
import com.example.demoTT.Repository.SeatRepo;
import com.example.demoTT.Repository.SeatSatusRepo;
import com.example.demoTT.Repository.SeatTypeRepo;
import com.example.demoTT.Services.SeatServices;
import com.example.demoTT.dto.Request.SeatRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatServicesImpl implements SeatServices {
    @Autowired
    public SeatRepo seatRepo;

    @Autowired
    public RoomRepo roomRepo;
    @Autowired
    public SeatSatusRepo seatSatusRepo;

    @Autowired
    public SeatTypeRepo seatTypeRepo;

    @Override
    public MessageResponse createSeat(SeatRequest seatRequest) {
        Room room = roomRepo.findById(seatRequest.getRoomid()).orElse(null);
        if (room == null){
            return MessageResponse.builder().message("Room không tồn tại").build();
        }
        SeatStatus seatStatus = seatSatusRepo.findById(seatRequest.getSeatstatusid()).orElse(null);
        if (seatStatus == null){
            return MessageResponse.builder().message("Seat Status không tồn tại").build();
        }
        SeatType seatType = seatTypeRepo.findById(seatRequest.getSeattypeid()).orElse(null);
        if (seatType == null){
            return MessageResponse.builder().message("Seat Type không tồn tại").build();
        }
        Seat seat = Seat.builder()
                .number(seatRequest.getNumber())
                .seattype(seatType)
                .seatstatus(seatStatus)
                .room(room)
                .line(seatRequest.getLine())
                .isActive(true)
                .build();
        seatRepo.save(seat);
        return MessageResponse.builder().message("Thêm seat thành công").build();
    }

    @Override
    public MessageResponse updateSeat(SeatRequest seatRequest, int id) {
        SeatStatus seatStatus = seatSatusRepo.findById(seatRequest.getSeattypeid()).orElse(null);
        SeatType seatType = seatTypeRepo.findById(seatRequest.getSeattypeid()).orElse(null);
        Room room = roomRepo.findById(seatRequest.getRoomid()).orElse(null);
        Optional<Seat> seatOptional = seatRepo.findById(id);
        if(seatStatus == null){
            return MessageResponse.builder().message("seatStatus không tồn tại").build();
        }
        if(seatType == null){
            return MessageResponse.builder().message("seatType không tồn tại").build();
        }
        if(room == null){
            return MessageResponse.builder().message("Room không tồn tại").build();
        }
        if(seatOptional.isEmpty()){
            return MessageResponse.builder().message("Seat không tồn tại").build();
        }
        Seat seat = seatOptional.get();
        seat.setSeatstatus(seatStatus);
        seat.setSeattype(seatType);
        seat.setRoom(room);
        seat.setLine(seatRequest.getLine());
        seat.setNumber(seatRequest.getNumber());
        seatRepo.save(seat);
        return MessageResponse.builder().message("Update lại seat thành công").build();

    }

    @Override
    public Seat deleteSeat(int id) {
        Optional<Seat> optionalSeat = seatRepo.findById(id);
        if (optionalSeat.isEmpty()){
            return null;
        }
        else {
            seatRepo.delete(optionalSeat.get());
        }
        return optionalSeat.get();
    }
}
