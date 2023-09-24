package com.finzly.bbcubp.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpGenerator {
private final int otpLength=6;
private String otp="";
public String generateOTP() {
    Random random = new Random();
    StringBuilder otp = new StringBuilder();
    for (int i = 0; i < otpLength; i++) {
        otp.append(random.nextInt(10));
    }
    return otp.toString();
}
}
