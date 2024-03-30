package com.example.demoTT.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {
    private String description;
    private String image;
    private String nameOfFood;
    private Double price;
}
