package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieid")
    private int movieID;
    @Column(name = "movieduration")
    private int movieDuration;
    @Column(name ="endtime")
    private LocalDate endTime;
    @Column(name = "premieredate")
    private LocalDate premiereDate;
    @Column(name = "description")
    private String description;
    @Column(name = "director")
    private String director;
    @Column(name ="image")
    private String Image;
    @Column(name = "heroimage")
    private String heroImage;
    @Column(name ="language")
    private String language;
    @Column(name = "name")
    private String name;
    @Column(name ="trailer")
    private String trailer;
    @Column(name = "isactive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "movietypeid")
    @JsonIgnore
    private MovieType movietype;
    @ManyToOne
    @JoinColumn(name = "rateid")
    @JsonIgnore
    private Rate rate;


    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties
    private Set<Schedule> schedules;


}
