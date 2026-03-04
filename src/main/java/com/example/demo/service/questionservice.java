package com.example.demo.service;

import com.example.demo.model.QuestionsModel;
import com.example.demo.repository.questionsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionservice {

    @Autowired
    private questionsrepo questionsrepo;

    public List<QuestionsModel> getAllQuestions(){
        return questionsrepo.findAll();
    }
}
