package com.example.demo.repository;

import com.example.demo.model.TorFModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorFrepo extends JpaRepository<TorFModel,Integer> {
}
