package com.example.demoTT.Controller;

import com.example.demoTT.Models.Room;
import com.example.demoTT.Services.Impl.RoomServicesImpl;
import com.example.demoTT.dto.Request.RoomRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    @Autowired
    private RoomServicesImpl roomServices;
    @PostMapping("createRoom")
    public ResponseEntity<MessageResponse> createRoom(@RequestBody RoomRequest roomRequest){
        return new ResponseEntity<>(roomServices.createRoom(roomRequest), HttpStatus.CREATED);
    }
    @PutMapping("updateroom")
    public ResponseEntity<MessageResponse> updateRoom(@RequestBody RoomRequest roomRequest, @RequestParam(name = "roomId") int id){
        return new ResponseEntity<>(roomServices.updateRoom(roomRequest, id), HttpStatus.OK);
    }
    @DeleteMapping(value ="deleteroom")
    public Room deleteRoom(@RequestParam int id){
        return roomServices.deleteRoom(id);
    }
}
