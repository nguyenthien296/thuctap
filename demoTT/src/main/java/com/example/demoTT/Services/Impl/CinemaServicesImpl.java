package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.*;
import com.example.demoTT.Repository.CinemaRepo;
import com.example.demoTT.Repository.DecentralizationRepo;
import com.example.demoTT.Repository.RoleRepo;
import com.example.demoTT.Services.CinemaServices;
import com.example.demoTT.dto.Request.CinemaRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaServicesImpl implements CinemaServices {
    @Autowired
    private CinemaRepo cinemaRepo;
    @Autowired
    private DecentralizationRepo decentralizationRepo;

    @Override
    public MessageResponse createCinema(CinemaRequest cinemaRequest) {
        Cinema newCinema = Cinema.builder()
                .nameOfCinema(cinemaRequest.getNameOfCinema())
                .address(cinemaRequest.getAddress())
                .isActive(true)
                .code(cinemaRequest.getCode())
                .Description(cinemaRequest.getDescription())
                .build();
        cinemaRepo.save(newCinema);
        return MessageResponse.builder().message("Them Cinema thanh cong").build();
    }

    @Override
    public MessageResponse updateCinema(CinemaRequest cinemaRequest, int id) {
        Optional<Cinema> cinemaOptional = cinemaRepo.findById(id);
        if (cinemaOptional.isPresent()){
            Cinema cinema = cinemaOptional.get();
            cinema.setNameOfCinema(cinemaRequest.getNameOfCinema());
            cinema.setDescription(cinemaRequest.getDescription());
            cinema.setAddress(cinemaRequest.getAddress());
            cinemaRepo.save(cinema);
            return MessageResponse.builder().message("Update Cinema thanh cong").build();
        }else
            return MessageResponse.builder().message("Cinema khong ton tai").build();
    }

    @Override
    public Cinema deleteCinema(int id) {
        Optional<Cinema> optionalCinema = cinemaRepo.findById(id);
        if (optionalCinema.isEmpty()){
            return null;
        }else {
            cinemaRepo.delete(optionalCinema.get());
        }
        return optionalCinema.get();
    }
}
