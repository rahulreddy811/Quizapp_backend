package com.example.demo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class EmailService {

    // Store OTP per email
    private Map<String, String> otpStorage = new HashMap<>();

    private final String API_KEY = "YOUR_RESEND_API_KEY";

    public void SendOtpEmail(String email){

        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        // store otp for that email
        otpStorage.put(email, otp);

        String url = "https://api.resend.com/emails";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> body = new HashMap<>();

        body.put("from", "onboarding@resend.dev");
        body.put("to", email);
        body.put("subject", "OTP Verification");
        body.put("text", "Your OTP is: " + otp);

        HttpEntity<Map<String,Object>> request = new HttpEntity<>(body, headers);

        restTemplate.postForObject(url, request, String.class);
    }

    public boolean VerifyOtp(String email,String inputOtp){

        String storedOtp = otpStorage.get(email);

        if(storedOtp != null && storedOtp.equals(inputOtp)){
            otpStorage.remove(email); // remove after verification
            return true;
        }

        return false;
    }
}