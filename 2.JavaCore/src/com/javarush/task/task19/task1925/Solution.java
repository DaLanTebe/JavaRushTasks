package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])){
            while(reader.ready()){
                String[] strings = reader.readLine().split(" ");
                for (String string : strings) {
                    if(string.length() > 6){
                        builder.append(string + ",");
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            writer.write(builder.toString());
        }
    }
}
