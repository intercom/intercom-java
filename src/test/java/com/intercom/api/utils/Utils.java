package com.intercom.api.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Utils {
    public static String randomString() {
        byte[] randomBytes = new byte[16];
        new SecureRandom().nextBytes(randomBytes);
        return String.format("%064x", new BigInteger(1, randomBytes));
    }
}
