package com.niit.java23;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Helper {
    public static String generateMD5(String plainText) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(plainText));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (Exception e) {

        }
        return null;

    }
}
