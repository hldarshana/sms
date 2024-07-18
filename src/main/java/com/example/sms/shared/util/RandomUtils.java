package com.example.sms.shared.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomUtils {

    private static final SecureRandom idGenerator = new SecureRandom();
    private static final long MSB = 0x8000000000000000L;

    /**
     * Generate a random string for use as a unique id
     * @return String
     */
    public String generateRandomId(){
        return Long.toHexString(MSB | idGenerator.nextLong()) + Long.toHexString(MSB | idGenerator.nextLong());
    }
}
