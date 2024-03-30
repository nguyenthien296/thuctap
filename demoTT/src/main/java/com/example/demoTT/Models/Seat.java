package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatid")
    private int id;
    @Column(name = "number")
    private int number;
    @Column(name = "line")
    private String line;
    @Column(name = "isactive")
    private boolean isActive;
    @OneToMany(mappedBy = "seat")
    @JsonIgnoreProperties
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "seatstatusid")
    @JsonIgnore
    private SeatStatus seatstatus;

    @ManyToOne
    @JoinColumn(name ="roomjid")
    @JsonIgnore
    private Room room;
    @ManyToOne
    @JoinColumn(name = "seattypeid")
    @JsonIgnore
    private SeatType seattype;


}