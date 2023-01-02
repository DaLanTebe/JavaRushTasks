package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))){
//            int counter = 0;
            Long counter = 0L;
            while (reader.ready()){
                String line = reader.readLine();
                String replace = line.replaceAll("\\p{P}", " ");
//                String[] split = replace.split(" ");
//                for (String string : split) {
//                    if (string.equalsIgnoreCase("world")){
//                        counter++;
//                    }
//                }
                counter += Arrays.stream(replace.split(" ")).filter(s -> s.equalsIgnoreCase("world"))
                        .count();
            }
            System.out.println(counter);
        }
    }
}
