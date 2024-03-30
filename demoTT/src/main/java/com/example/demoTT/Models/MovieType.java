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
@Table(name = "movietype")
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movietypeid")
    private int movieTypeID;
    @Column(name = "name")
    private String movieTypeName;
    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(mappedBy ="movietype")
    @JsonIgnoreProperties
    private Set<Movie> movies;


}