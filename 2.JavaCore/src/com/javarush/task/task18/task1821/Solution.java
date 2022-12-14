package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new TreeMap<>();
        try (FileInputStream inputStream = new FileInputStream(args[0])){
            while (inputStream.available() > 0){
                char read = (char) inputStream.read();
//                if (!map.containsKey(read)){
//                    map.put(read, 1);
//                }else {
//                    map.put(read, map.get(read) + 1);
//                }
                map.merge(read,1, Integer::sum);
            }
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
