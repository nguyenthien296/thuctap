package com.example.demoTT.Repository;

import com.example.demoTT.Models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepo extends JpaRepository<Rate, Integer> {
}
