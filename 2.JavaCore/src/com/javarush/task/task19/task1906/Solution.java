package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(console.readLine());
        FileWriter writer = new FileWriter(console.readLine())){

            StringBuilder builder = new StringBuilder();

            while (reader.ready()){
                builder.append((char) reader.read());
            }
            System.out.println(builder);
            char[] chars = builder.toString().toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                writer.write(chars[i]);
            }
        }
    }
}
