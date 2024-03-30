package com.example.demoTT.Repository;

import com.example.demoTT.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String name);

    Optional<User> findByEmail(String email);
}
