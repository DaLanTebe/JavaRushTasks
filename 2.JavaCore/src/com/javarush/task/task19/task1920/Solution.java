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
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String line = reader.readLine();
                String[] strings = line.split(" ");
                String name = strings[0];
                double aDouble = Double.parseDouble(strings[1]);
                map.merge(name, aDouble, Double::sum);
            }
            double max = Double.MIN_VALUE;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() > max){
                    max = entry.getValue();
                    set.clear();
                    set.add(entry.getKey());
                }else if (entry.getValue() == max){
                    set.add(entry.getKey());
                }
            }
            set.forEach(System.out::println);
        }
    }
}
