package com.example.demoTT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieTicketCountDTO {
    private Integer movieId;
    private String movieName;
    private String movieImage;
    private Integer movieDuration;
    private String movieTrailer;
    private String movieTypeName;
    private String movieDescription;
    private String movieDirector;
    private String movieLanguage;
}
