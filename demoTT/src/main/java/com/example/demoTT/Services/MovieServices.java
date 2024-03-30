package com.example.demoTT.Services;

import com.example.demoTT.Models.Movie;
import com.example.demoTT.dto.MovieTicketCountDTO;
import com.example.demoTT.dto.Request.MovieRequest;
import com.example.demoTT.dto.Response.MessageResponse;

public interface MovieServices {
    MessageResponse createMovie(MovieRequest movieRequest);
    MessageResponse updateMoive(MovieRequest movieRequest, int id);
    public Movie deleteMoive(int id);
}
