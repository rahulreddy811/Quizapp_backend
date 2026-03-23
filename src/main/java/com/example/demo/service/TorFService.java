package com.example.demo.service;

import com.example.demo.model.TorFModel;
import com.example.demo.repository.TorFrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorFService {

    @Autowired
    TorFrepo repo;

    public List<TorFModel> getAll(){
        return repo.findAll();
    }
}
