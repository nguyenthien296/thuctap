package com.example.demoTT.Controller;

import com.example.demoTT.Models.Cinema;
import com.example.demoTT.Services.Impl.CinemaServicesImpl;
import com.example.demoTT.dto.Request.CinemaRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cinema/")
public class CinemaController {
    @Autowired
    private CinemaServicesImpl cinemaServices;


    @PostMapping("createcinema")
    public ResponseEntity<MessageResponse> createCinema(@RequestBody CinemaRequest cinemaRequest){
        return new ResponseEntity<>(cinemaServices.createCinema(cinemaRequest), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "deletecinema")
    public Cinema deleteCinema(@RequestParam int id){
        return cinemaServices.deleteCinema(id);
    }
    @PutMapping("updatecinema")
    public ResponseEntity<MessageResponse> updateCinema(@RequestBody CinemaRequest cinemaRequest, @RequestParam(name = "cinemaId") int id){
        return new ResponseEntity<>(cinemaServices.updateCinema(cinemaRequest, id), HttpStatus.OK);
    }
}
