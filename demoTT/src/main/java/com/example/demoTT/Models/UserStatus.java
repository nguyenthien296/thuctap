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
@Table(name = "userstatus")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userstatusid")
    private int id;
    @Column(name = "code")
    private  String code;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "userstatus")
    @JsonIgnoreProperties
    private Set<User> users;



}