package com.javarush.task.task19.task1908;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))){
            while (reader.ready()){
                String s = reader.readLine();
                String[] split = s.split(" ");
                for (String string : split) {
                    if (string.matches("\\d+")){
                        writer.write(string + " ");
                    }
                }
            }
        }
    }
}
