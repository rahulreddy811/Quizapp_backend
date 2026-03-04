package com.example.demo.Controller;

import com.example.demo.model.QuestionsModel;
import com.example.demo.service.questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz/question")
public class questioncontroller {

    @Autowired
    private questionservice questionservice;

    @GetMapping
    public List<QuestionsModel> getAllQuestion(){
       return  questionservice.getAllQuestions();
    }
}
