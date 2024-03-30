package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid")
    private int billID;
    @Column(name = "totalmoney")
    private double TotalMoney;
    @Column(name = "tradingcode")
    private String TradingCode;
    @Column(name = "createtime")
    private LocalDate CreateTime;
    @Column(name = "name")
    private String name;
    @Column(name = "uodatetime")
    private LocalDate updateTime;
    @Column(name = "isactive")
    private boolean isActive;
    @OneToMany(mappedBy = "bill")
    @JsonIgnoreProperties
    private Set<BillFood> billFoods;
    @OneToMany(mappedBy = "bill")
    @JsonIgnoreProperties
    private Set<BillTicket> billTickets;

    @ManyToOne
    @JoinColumn(name = "Customerid")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "billstatusid")
    @JsonIgnore
    private BillStatus billStatus;
    @ManyToOne
    @JoinColumn(name = "promotionid")
    @JsonIgnore
    private Promotion promotion;
}
