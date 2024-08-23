package com.twilio_otp_verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio_otp_verification.config.TwilioConfig;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TwilioOtpVerificationApplication {
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	@PostConstruct
	public void initTwilio() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(TwilioOtpVerificationApplication.class, args);
	}

}
