package com.example.demoTT.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private Integer capacity;
    private Integer type;
    private String description;
    private String code;
    private String name;
    private Integer cinemaId;
}
