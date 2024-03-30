package com.example.demoTT.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private int movieDuration;

    private LocalDate endTime;

    private LocalDate premiereDate;

    private String description;

    private String director;

    private String image;

    private String heroImage;

    private String language;

    private String name;

    private String trailer;

    private int movieTypeId;

    private int rateId;
}
