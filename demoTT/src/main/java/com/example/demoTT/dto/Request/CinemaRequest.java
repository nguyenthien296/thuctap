package com.example.demoTT.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRequest {
    private int cinemaId;
    private String address;
    private String  code;
    private String description;

    private String nameOfCinema;
}
