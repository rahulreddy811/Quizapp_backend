package com.example.demo.Controller;

import com.example.demo.model.usermodel;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz/users")
public class usercontroller {

    @Autowired
    private userService userService;

    @GetMapping
    public List<usermodel> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public ResponseEntity<usermodel> getUserByUsername(@PathVariable String username){
        Optional<usermodel> user = userService.getUserByUsername(username);

        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping
    public String CreateUser(@RequestBody usermodel userDetails){
       return userService.save(userDetails);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<usermodel> deleteUser(@PathVariable String username){
        Optional<usermodel> deletedUser = userService.deleteUser(username);

        if (deletedUser.isPresent()){
            return ResponseEntity.ok(deletedUser.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody usermodel data){

        String message = userService.login(data);
        return ResponseEntity.ok(message);
    }
}
