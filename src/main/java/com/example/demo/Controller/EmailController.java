package com.example.demo.Controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz/otp")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    public String SendOtp(@RequestParam String email){
        emailService.SendOtpEmail(email);
        return "Otp Sent Successfully";
    }

    @PostMapping("/verify")
    public String VerifyOtp(@RequestParam String otp){

        if (emailService.VerifyOtp(otp)){
            return "otp verifies successfully";
        }
        else {
           return "Invalid Otp";
        }
    }
}
