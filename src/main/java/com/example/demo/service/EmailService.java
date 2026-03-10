package com.example.demo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private String otp;

    private final String API_KEY = "re_Nbd6R2co_K88Lw11t2fLrXRujou25fe1X";

    public void SendOtpEmail(String email){

        otp = String.valueOf((int)(Math.random()*900000)+100000);

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

    public boolean VerifyOtp(String inputOtp){
        return otp != null && otp.equals(inputOtp);
    }
}