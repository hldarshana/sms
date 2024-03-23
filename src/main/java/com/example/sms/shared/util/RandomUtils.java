package com.example.sms.shared.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomUtils {

    private static volatile SecureRandom idGenerator = null;
    private static final long MSB = 0x8000000000000000L;

    /**
     * Generate a random string for use as a unique id
     * @return String
     */
    public String generateRandomId(){
        SecureRandom ng = idGenerator;
        if (ng == null) {
            idGenerator = ng = new SecureRandom();
        }

        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }
}
