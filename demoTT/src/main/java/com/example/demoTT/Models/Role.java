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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    @Enumerated
    private ERole roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties
    private Set<User> users;
}

