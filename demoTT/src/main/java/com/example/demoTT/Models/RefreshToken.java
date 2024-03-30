package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "refreshtoken")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refreshtokenid")
    private int id;
    @Column(name = "token")
    private String toKen;
    @Column(name = "expiredtime")
    private LocalDate expiredTime;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;


}

