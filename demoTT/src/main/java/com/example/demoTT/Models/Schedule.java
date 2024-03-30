package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedeuleid")
    private int id;
    @Column(name = "price")
    private double price;
    @Column(name = "startat")
    private LocalDate startAt;
    @Column(name = "endat")
    private LocalDate endAt;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "isactive")
    private boolean isActive;
    @OneToMany(mappedBy = "schedule")
    @JsonIgnoreProperties
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "movieid")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "roomid")
    @JsonIgnore
    private Room room;


}
