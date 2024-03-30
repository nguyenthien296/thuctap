package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "seattype")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seattyoeid")
    private int id;
    @Column(name = "namemtype")
    private String nametype;
    @OneToMany(mappedBy = "seattype")
    @JsonIgnoreProperties
    private Set<Seat> seats;


}
