package com.example.onlineAssessment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.security.SecureRandom;
import java.util.Base64;

public class SessionUtils {
    private static final SecureRandom   secureRandom  = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @Autowired
    private              RedisTemplate  redisTemplate;

    public static String generateNewSessionToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

}
