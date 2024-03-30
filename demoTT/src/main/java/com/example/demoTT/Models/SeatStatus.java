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
@Table(name = "seatstatus")
public class SeatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatstatusid")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "namestatus")
    private String nameStatus;
    @OneToMany(mappedBy ="seatstatus")
    @JsonIgnoreProperties
    private Set<Seat> seats;


}
