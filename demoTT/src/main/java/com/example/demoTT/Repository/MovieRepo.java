package com.example.demoTT.Repository;

import com.example.demoTT.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
