package com.example.demoTT.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest {
    private String line;
    private Integer number;
    private Integer roomid;
    private Integer seatstatusid;
    private Integer seattypeid;
}
