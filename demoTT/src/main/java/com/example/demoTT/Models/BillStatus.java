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
@Table(name = "billstatus")
public class BillStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billstatusid")
    private int billStatusID;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "billStatus")
    @JsonIgnoreProperties
    private Set<Bill> bills;
}