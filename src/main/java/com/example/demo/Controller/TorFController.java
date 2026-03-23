package com.example.demo.Controller;

import com.example.demo.model.QuestionsModel;
import com.example.demo.model.TorFModel;
import com.example.demo.service.TorFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz/question/TorF")
public class TorFController {

    @Autowired
    private TorFService service;

    @GetMapping
    public List<TorFModel> getAll(){
        return service.getAll();
    }
}
