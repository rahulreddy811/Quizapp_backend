package com.example.demo.repository;

import com.example.demo.model.usermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<usermodel,Integer> {
    Optional<usermodel> findByUsername(String username);
}
