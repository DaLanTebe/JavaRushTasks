package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))){
            while (reader.ready()){
                String line = reader.readLine();
                String[] split = line.split(" ");
                if (split[0].equals(args[0])){
                    System.out.println(line);
                }
            }
        }
    }
}
