package com.example.demoTT.Services;

import com.example.demoTT.Models.Food;
import com.example.demoTT.dto.Request.FoodRequest;
import com.example.demoTT.dto.Response.MessageResponse;

public interface FoodServices {
    MessageResponse createFood(FoodRequest foodRequest);
    MessageResponse updateFood(FoodRequest foodRequest, int id);
    public Food deletefood(int id);
}
