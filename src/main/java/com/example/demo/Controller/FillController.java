package com.example.demo.Controller;

import com.example.demo.model.FillinBlanksModel;
import com.example.demo.service.FillinBlanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz/question/Fill")
public class FillController {

    @Autowired
    private FillinBlanksService service;

    @GetMapping
    public List<FillinBlanksModel> getAllFill(){
        return service.getAllFill();
    }
}
