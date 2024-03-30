package com.example.demoTT.Repository;

import com.example.demoTT.Models.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTypeRepo extends JpaRepository<MovieType, Integer> {
}
