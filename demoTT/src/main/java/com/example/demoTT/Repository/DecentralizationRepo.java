package com.example.demoTT.Repository;

import com.example.demoTT.Models.Decentralization;
import com.example.demoTT.Models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DecentralizationRepo extends JpaRepository<Decentralization, Integer> {
    Optional<Decentralization> findByAuthorityName(ERole name);
}
