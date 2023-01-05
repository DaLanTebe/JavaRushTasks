package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] byteArray = new int[256];
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(console.readLine())) {
            while (fileInputStream.available() > 0) {
                byteArray[fileInputStream.read()]++;
            }
        }
        int[] ints = IntStream.range(0, byteArray.length).filter(i -> byteArray[i] == Arrays.stream(byteArray).min().getAsInt()).toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
