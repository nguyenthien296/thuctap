package com.example.demoTT.Controller;

import com.example.demoTT.Models.Movie;
import com.example.demoTT.Services.Impl.MovieServicesImpl;
import com.example.demoTT.dto.Request.MovieRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/movie/")
public class MovieController {
    @Autowired
    private MovieServicesImpl movieServices;
    @PostMapping("createmovie")
    public ResponseEntity<MessageResponse> createMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(movieServices.createMovie(movieRequest), HttpStatus.CREATED);
    }
    @PutMapping("updatemovie")
    public ResponseEntity<MessageResponse> updateMovie(@RequestBody MovieRequest movieRequest, @RequestParam(name = "movieId") int id){
        return new ResponseEntity<>(movieServices.updateMoive(movieRequest, id), HttpStatus.OK);
    }
    @DeleteMapping(value = "deletemoive")
    public Movie deleteMovie(@RequestParam int id){
        return movieServices.deleteMoive(id);
    }
}
