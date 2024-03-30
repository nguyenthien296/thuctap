package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodid")
    public int foodID;
    @Column(name = "price")
    public double price;
    @Column(name = "description")
    public String Description;
    @Column(name = "image")
    public String Image;
    @Column(name = "nameoffood")
    public String NameOfFood;
    @Column(name = "isactive")
    public boolean isActive;
    @OneToMany(mappedBy = "food")
    @JsonIgnoreProperties
    public Set<BillFood> billFoods;


}