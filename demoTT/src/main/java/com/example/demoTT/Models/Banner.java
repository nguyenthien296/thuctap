package com.example.demoTT.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bannerid")
    public int bannerID;
    @Column(name = "imageurl")
    private String ImageUrl;
    @Column(name = "title")
    private String title;

}


