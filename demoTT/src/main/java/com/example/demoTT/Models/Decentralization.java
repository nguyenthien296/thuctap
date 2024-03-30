package com.example.demoTT.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "decentralization")
public class Decentralization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decentralization_id")
    private Integer decentralizationId;

    @Column(name = "Authority_name")
    @Enumerated(EnumType.STRING)
    private ERole authorityName;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "update_at")
    private LocalDate updateAt;

    @OneToMany(mappedBy = "decentralization", fetch = FetchType.LAZY)
    private List<User> accountList;

    public boolean isAuthority(ERole erole) {
        return this.authorityName.equals(erole.getAuthority());
    }
}


