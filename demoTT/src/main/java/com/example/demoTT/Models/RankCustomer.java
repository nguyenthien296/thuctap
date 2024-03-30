package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rankcustomer")
public class RankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rankcustomerid")
    private int id;
    @Column(name = "point")
    private int point;
    @Column(name = "description")
    private String decsription;
    @Column(name = "name")
    private String name;
    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(mappedBy = "rankcustomer")
    @JsonIgnoreProperties
    private Set<User> users;

    @OneToMany(mappedBy = "rankcustomer")
    @JsonIgnoreProperties
    private Set<Promotion> promotions;
}
