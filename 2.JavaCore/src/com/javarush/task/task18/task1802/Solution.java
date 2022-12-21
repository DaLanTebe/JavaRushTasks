package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(console.readLine())){
            int minByte = 255;
            int read;
            while (inputStream.available() > 0){
                read = inputStream.read();
                if (minByte > read){
                    minByte = read;
                }
            }
            System.out.println(minByte);
        }
    }
}
