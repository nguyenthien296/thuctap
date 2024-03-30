package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinemaid")
    private int cinemaID;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String Description;
    @Column(name = "code")
    private String code;
    @Column(name = "nameofcinema")
    private String nameOfCinema;
    @Column(name = "isactive")
    private boolean isActive;
    @OneToMany(mappedBy = "cinema")
    @JsonIgnoreProperties
    private Set<Room> rooms;
}
