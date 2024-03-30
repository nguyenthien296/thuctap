package com.example.demoTT.Services;

import com.example.demoTT.Models.Cinema;
import com.example.demoTT.dto.Request.CinemaRequest;
import com.example.demoTT.dto.Response.MessageResponse;

public interface CinemaServices {
    MessageResponse createCinema(CinemaRequest cinemaRequest);
    MessageResponse updateCinema(CinemaRequest cinemaRequest, int id);
    public Cinema deleteCinema(int id);
}
