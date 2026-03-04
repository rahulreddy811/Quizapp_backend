package com.example.demo.service;

import com.example.demo.model.usermodel;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private UserRepo userRepo;

    public List<usermodel> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<usermodel> getUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public usermodel save(usermodel userModel){
        return userRepo.save(userModel);
    }

    public Optional<usermodel> deleteUser(String username){
        Optional<usermodel> userOptional = userRepo.findByUsername(username);
            userOptional.ifPresent(userRepo::delete);
            return userOptional;
    }

    public String login(usermodel usermodel){

        String username = usermodel.getUsername().trim();
        String password = usermodel.getPassword().trim();

        System.out.println("Login Attempt for User"+username);

        Optional<usermodel> userexistence = userRepo.findByUsername(username);

        if (userexistence.isEmpty()){
            return "user not found";
        }

        com.example.demo.model.usermodel use = userexistence.get();

        if(use.getPassword().trim().equals(password)){
            return "Login Successful";
        }
        else {
            return "incorrect Password";
        }
    }
}
