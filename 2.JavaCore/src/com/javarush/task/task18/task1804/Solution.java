package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] byteArray = new int[256];
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(console.readLine())) {
            while (fileInputStream.available() > 0) {
                byteArray[fileInputStream.read()]++;
            }
        }
//        final int minimum = Integer.MAX_VALUE;
//        IntStream.range(0, byteArray.length)
//                .filter(i -> i > 0)
//                .filter(i -> byteArray[i] == Arrays.stream(byteArray).min().getAsInt())
//                .boxed()
//                .collect(Collectors.toList())
//                .forEach(index -> System.out.print(index + " "));
//
//
        int min = Integer.MAX_VALUE;
        for (int count : byteArray) {
            if (count > 0 && count < min) {
                min = count;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] == min) {
                list.add(i);
            }
        }
        list.forEach(index -> System.out.print(index + " "));
    }

    private static void method() throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(console.readLine())) {
            while (fileInputStream.available() > 0) {
                map.merge(fileInputStream.read(), 1, Integer::sum);
            }
        }

        map.forEach((k,v) -> System.out.println(Objects.equals(v, map.values().stream().min(Integer::compareTo).get()) ? k + " " : ""));
    }
}
