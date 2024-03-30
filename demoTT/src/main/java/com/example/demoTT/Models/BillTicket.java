package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "billticket")
public class BillTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billtichketid")
    private int id;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ticketid")
    @JsonIgnore
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "billid")
    @JsonIgnore
    private Bill bill;


}
