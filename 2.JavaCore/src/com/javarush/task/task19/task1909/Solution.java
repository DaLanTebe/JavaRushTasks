package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))){
            while (reader.ready()){
                writer.write(reader.readLine().replaceAll("[.]", "!"));
            }
        }
    }
}
