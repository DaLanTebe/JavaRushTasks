package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(console.readLine())){
            List<Integer> list = new ArrayList<>();
            while (inputStream.available() > 0){
                int read = inputStream.read();
                if(!list.contains(read)){
                    list.add(read);
                }
            }
            Collections.sort(list);
            list.forEach(obj -> System.out.print(obj + " "));
        }
    }
}
