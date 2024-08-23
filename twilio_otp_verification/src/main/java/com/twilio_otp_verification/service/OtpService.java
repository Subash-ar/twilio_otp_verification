package com.twilio_otp_verification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio_otp_verification.config.TwilioConfig;

@Service
public class OtpService {
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	public boolean sendOtp (String to, String otp){
        try{
            Message.creator(new PhoneNumber(to),new PhoneNumber(twilioConfig.getTrialNumber()),"Your OTP is:"+ otp).create();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

	

}
