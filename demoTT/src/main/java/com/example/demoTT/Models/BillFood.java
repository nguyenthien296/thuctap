package com.example.demoTT.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "billfood")
public class BillFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billfoodid")
    private int billFoodID;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "foodid")
    @JsonIgnore
    private Food food;

    @ManyToOne
    @JoinColumn(name = "billid")
    @JsonIgnore
    private Bill bill;
}


