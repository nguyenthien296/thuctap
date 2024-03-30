package com.example.demoTT.Controller;

import com.example.demoTT.Models.Food;
import com.example.demoTT.Services.Impl.FoodServicesImpl;
import com.example.demoTT.dto.Request.FoodRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food/")
public class FoodController {
    @Autowired
    private FoodServicesImpl foodServices;
    @PostMapping("createFood")
    public ResponseEntity<MessageResponse> createFood(@RequestBody FoodRequest foodRequest){
        return new ResponseEntity<>(foodServices.createFood(foodRequest), HttpStatus.CREATED);
    }
    @PutMapping("updatefood")
    public ResponseEntity<MessageResponse> updateFood(@RequestBody FoodRequest foodRequest, @RequestParam(name = "foodId") int id){
        return new ResponseEntity<>(foodServices.updateFood(foodRequest, id), HttpStatus.OK);
    }
    @DeleteMapping(value = "deletefood")
    public Food deleteFood(@RequestParam int id){
        return foodServices.deletefood(id);
    }
}
