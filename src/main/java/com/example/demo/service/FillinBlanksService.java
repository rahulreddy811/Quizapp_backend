package com.example.demo.service;

import com.example.demo.model.FillinBlanksModel;
import com.example.demo.repository.FillinBlanksrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillinBlanksService {

    @Autowired
    FillinBlanksrepo repo;

    public List<FillinBlanksModel> getAllFill(){
        return repo.findAll();
    }
}
