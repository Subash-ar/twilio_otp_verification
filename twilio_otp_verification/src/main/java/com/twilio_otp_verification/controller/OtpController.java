package com.twilio_otp_verification.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio_otp_verification.service.OtpService;


@RestController
public class OtpController {

    
    @Autowired
    private OtpService otpService;
    
    private Map<String, String> otpStorage = new HashMap<>();

    @PostMapping("/send_otp")
    public String sendOtp(@RequestParam String phoneNumber){
     
        String otp = generateRandomOtp(6);
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            // Handle the case where phoneNumber is missing
            return "Phone number is required.";
        }
        if(otpService.sendOtp("+"+phoneNumber,otp)){
            otpStorage.put("+"+phoneNumber,otp);
            return "OTP sent successfully";
        }else {
            return "failed to send OTP";
        }
    }
    
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp){
        String storedOtp= otpStorage.get("+"+phoneNumber);
        if(storedOtp!=null && storedOtp.equals(otp) ){
            otpStorage.remove("+"+phoneNumber);
            return "OTP verified successfully";
        }else {
            return "Invalid OTP";
        }
    }


	private String generateRandomOtp(int length) {
		  String characters = "0123456789";
	        Random random = new Random();
	        StringBuilder otp = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            otp.append(characters.charAt(random.nextInt(characters.length())));
	        }

	        return otp.toString();
	    }
	}

	

