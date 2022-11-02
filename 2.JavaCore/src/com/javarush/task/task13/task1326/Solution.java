package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner console = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(console.nextLine())))
        ){
            List<Integer> list = new ArrayList<>();
            while (reader.ready()){
                int number = Integer.parseInt(reader.readLine().trim());
                if (number % 2 == 0){
                    list.add(number);
                }
            }
//            list.sort(Comparator.comparingInt(o -> o));
            Collections.sort(list);
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }
}
