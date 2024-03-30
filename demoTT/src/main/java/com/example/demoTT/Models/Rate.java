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
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rateid")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "rate")
    @JsonIgnoreProperties
    private Set<Movie> movies;


}