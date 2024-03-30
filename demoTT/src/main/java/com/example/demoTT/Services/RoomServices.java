package com.example.demoTT.Services;

import com.example.demoTT.Models.Cinema;
import com.example.demoTT.Models.Room;
import com.example.demoTT.dto.Request.RoomRequest;
import com.example.demoTT.dto.Response.MessageResponse;

public interface RoomServices {
    MessageResponse createRoom(RoomRequest roomRequest);
    MessageResponse updateRoom(RoomRequest roomRequest, int id);
    public Room deleteRoom(int id);
}
