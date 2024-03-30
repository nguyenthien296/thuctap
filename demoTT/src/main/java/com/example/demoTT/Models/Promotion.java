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
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotionid")
    private int id;
    @Column(name = "percent")
    private int percent;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "type")
    private String type;
    @Column(name = "starttime")
    private LocalDate startTime;
    @Column(name = "endtime")
    private LocalDate endTime;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(mappedBy = "promotion")
    @JsonIgnoreProperties
    private Set<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "rankcustomerid")
    @JsonIgnore
    private RankCustomer rankcustomer;


}
