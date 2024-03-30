package com.example.demoTT.Controller;

import com.example.demoTT.Models.Seat;
import com.example.demoTT.Repository.SeatRepo;
import com.example.demoTT.Services.Impl.SeatServicesImpl;
import com.example.demoTT.dto.Request.SeatRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {
    @Autowired
    private SeatServicesImpl seatServices;
    @PostMapping("createSeat")
    public ResponseEntity<MessageResponse> createSeat(@RequestBody SeatRequest seatRequest) {
        return new ResponseEntity<>(seatServices.createSeat(seatRequest), HttpStatus.CREATED);
    }
    @PutMapping("updateSeat")
    public ResponseEntity<MessageResponse> updateSeat(@RequestBody SeatRequest seatRequest, @RequestParam(name = "seatId") int id){
            return new ResponseEntity<>(seatServices.updateSeat(seatRequest, id), HttpStatus.OK);
    }
    @DeleteMapping(value = "deleteSeat")
    public Seat delateSeat(@RequestParam int id){
        return seatServices.deleteSeat(id);
    }
}
