package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "priveticket")
    private double priceTicket;
    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(mappedBy = "ticket")
    @JsonIgnoreProperties
    private Set<BillTicket> billTickets;


    @ManyToOne
    @JoinColumn(name ="seatid")
    @JsonIgnore
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "scheduleid")
    @JsonIgnore
    private Schedule schedule;


}
