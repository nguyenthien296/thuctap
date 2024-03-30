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
@Builder
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userID;
    @Column(name = "point")
    private int point;
    @Column(name = "username")
    private String userName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "password", nullable = false)
    private String passwWord;
    @Column(name = "confirm_code")
    private String confirmCode;
    @Column(name = "ResetPasswordToken")
    private String resetPasswordToken;
    @Column(name = "ResetPasswordTokenExpiry")
    private LocalDate resetPasswordTokenExpiry;
    @Column(name = "isactive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "userstatusid")
    @JsonIgnore
    private UserStatus userstatus;

    @ManyToOne
    @JoinColumn(name = "rankcustomerid")
    @JsonIgnore
    private RankCustomer rankcustomer;

    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnore
    private Role role;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties
    private Set<ConfirmEmail> confirmemails;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties
    private Set<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "decentralization_id")
    @Enumerated(EnumType.STRING)
    private Decentralization decentralization;


}