package com.example.demoTT.Services;

import com.example.demoTT.Models.Room;
import com.example.demoTT.Models.Seat;
import com.example.demoTT.dto.Request.SeatRequest;
import com.example.demoTT.dto.Response.MessageResponse;

public interface SeatServices {
    MessageResponse createSeat(SeatRequest seatRequest);
    MessageResponse updateSeat(SeatRequest seatRequest, int id);
    public Seat deleteSeat(int id);
}
