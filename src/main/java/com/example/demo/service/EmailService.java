package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class EmailService {

    @Autowired
    private JavaMailSender MailSender;
    private String GeneratedOtp;

    public void SendOtpEmail(String toEmail){

        Random random = new Random();
        GeneratedOtp = String.valueOf(100000+ random.nextInt(900000));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Quiz app Otp");
        message.setText("Your OTP is: " + GeneratedOtp + "\nValid for 5 minutes.");
        message.setFrom("yourgmail@gmail.com");

        MailSender.send(message);
    }

    public boolean VerifyOtp(String otp){
        return otp.equals(GeneratedOtp);
    }
}
