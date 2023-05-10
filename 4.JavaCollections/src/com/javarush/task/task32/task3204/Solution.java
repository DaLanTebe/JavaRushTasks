package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char[] password = new char[8];
        Random random = new Random();
        String string = "";
        while (!string.matches(".*\\d.*") || !string.matches(".*[a-z].*") || !string.matches(".*[A-Z].*")) {
            for (int i = 0; i < password.length; i++) {
                password[i] = alphabet.charAt(random.nextInt(alphabet.length()));
            }
            string = new String(password);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(string.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream;
    }
}
