package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String line = reader.readLine();
                String[] s = line.split(" ");
                if (map.containsKey(s[0])){
                    map.put(s[0],map.get(s[0]) + Double.parseDouble(s[1]));
                }else map.put(s[0], Double.parseDouble(s[1]));
            }
            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key).toString());
            }
        }
    }
}
