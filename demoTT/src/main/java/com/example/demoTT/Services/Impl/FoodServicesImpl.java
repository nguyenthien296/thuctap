package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Food;
import com.example.demoTT.Repository.FoodRepo;
import com.example.demoTT.Services.FoodServices;
import com.example.demoTT.dto.Request.FoodRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServicesImpl implements FoodServices {
    @Autowired
    public FoodRepo foodRepo;

    @Override
    public MessageResponse createFood(FoodRequest foodRequest) {
        Food food = Food.builder()
                .NameOfFood(foodRequest.getNameOfFood())
                .Image(foodRequest.getImage())
                .price(foodRequest.getPrice())
                .isActive(true)
                .Description(foodRequest.getDescription())
                .build();
        foodRepo.save(food);
        return MessageResponse.builder().message("Them food thanh cong").build();
    }

    @Override
    public MessageResponse updateFood(FoodRequest foodRequest, int id) {
        Optional<Food> foodOptional = foodRepo.findById(id);
        if (foodOptional.isPresent()){
            Food food = foodOptional.get();
            food.setNameOfFood(foodRequest.getNameOfFood());
            food.setPrice(foodRequest.getPrice());
            food.setDescription(foodRequest.getDescription());
            food.setImage(foodRequest.getImage());
            foodRepo.save(food);
            return MessageResponse.builder().message("Update Food thanh cong").build();
        }else {
            return MessageResponse.builder().message("Food khong ton tai").build();
        }
    }

    @Override
    public Food deletefood(int id) {
        Optional<Food> optionalFood = foodRepo.findById(id);
        if (optionalFood.isEmpty()){
            return null;
        }
        else {
            foodRepo.delete(optionalFood.get());
        }
        return optionalFood.get();
    }
}
