package com.example.demo.repository;

import com.example.demo.model.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface questionsrepo extends JpaRepository<QuestionsModel,Integer> {
}
