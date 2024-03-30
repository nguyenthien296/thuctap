package com.example.demoTT.Repository;

import com.example.demoTT.Models.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeatSatusRepo extends JpaRepository<SeatStatus, Integer> {
}
