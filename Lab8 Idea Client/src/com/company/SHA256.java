package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface SHA256 {
    public static String getHash(String password) {
        byte[] hashBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] data = password.getBytes();
            hashBytes = md.digest(data);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Big oof....");
        }
        return new String(hashBytes, StandardCharsets.UTF_8);
    }
}
