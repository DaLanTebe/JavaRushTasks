package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        int countOfSymbols = 0;
        int countOfSpaces = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String line = reader.readLine();
                for (Character character : line.toCharArray()){
                    if (character.equals(' ')) {
                        countOfSpaces++;
                    }
                    countOfSymbols++;
                }
            }
            double result = (double) countOfSpaces / countOfSymbols * 100;
            System.out.printf("%.2f", result);
        }
    }
}
