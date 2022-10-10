package com.javarush.task.pro.task15.task1501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Сокращаем try
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(reader.readLine().toLowerCase());
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
