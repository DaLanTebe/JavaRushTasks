package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String[] split = reader.readLine().split(" ");
                if (map.containsKey(split)){
                    map.put(split[0], map.get(split[0]) + Double.parseDouble(split[1]));
                }else map.put(split[0], Double.parseDouble(split[1]));
            }
            List<String> list = new ArrayList<>(map.keySet());
        }
    }
}
