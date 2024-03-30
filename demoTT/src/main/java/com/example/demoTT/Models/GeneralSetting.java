package com.example.demoTT.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "generalsetting")
public class GeneralSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "generalsettingid")
    private int id;
    @Column(name = "breaktime")
    private LocalDate breakTime;
    @Column(name = "businesshours")
    private int businessHours;
    @Column(name = "closetime")
    private LocalDate closeTime;
    @Column(name = "fixedticketprice")
    private double fixedTicketPrice;
    @Column(name = "percentday")
    private int persentDay;
    @Column(name = "percentWeekend")
    private int percentWeekend;
    @Column(name = "timebeginTochange")
    private LocalDate timeBeginToChange;

}
