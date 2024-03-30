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
@Table(name = "confirmemail")
public class ConfirmEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confoirmemialid")
    private int id;
    @Column(name = "requiredtime")
    private LocalDate requiredTime;
    @Column(name = "expiredtime")
    private LocalDate expiredTime;
    @Column(name = "confirmcode")
    private String confirmCode;
    @Column(name = "isconfirm")
    private boolean isConfirm;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;


}
