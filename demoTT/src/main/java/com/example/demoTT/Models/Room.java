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
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomid")
    private int id;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "type")
    private int type;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private int code;
    @Column(name = "name")
    private String name;
    @Column(name ="isactive")
    private boolean isActive;

    @OneToMany(mappedBy = "room")
    @JsonIgnoreProperties
    private Set<Schedule> schedules;
    @OneToMany(mappedBy = "room")
    @JsonIgnoreProperties
    private Set<Seat> seats;

    @ManyToOne
    @JoinColumn(name ="cinemaid")
    @JsonIgnore
    private Cinema cinema;


}