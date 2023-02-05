package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(console.readLine());
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String[] split = null;
            while (reader.ready()) {
                String line = reader.readLine();
                split = line.split(" ");
            }
            System.out.println(getLine(split).toString());
        }
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0) {
            return new StringBuilder();
        }

        StringBuilder builder = new StringBuilder();

        List<StringBuilder> builderList = new ArrayList<>();

        for (String word : words) {

            builder.append(word);

            List<String> list = new ArrayList<>(Arrays.asList(words));
            list.remove(word);

            int counter = 0;
            while (!list.isEmpty()) {
                String firstStartChar = builder.substring(0, 1);
                String firstEndChar = builder.substring(builder.length() - 1);

                String secondStartChar = list.get(0).substring(0, 1);
                String secondEndChar = list.get(0).substring(list.get(0).length() - 1);

                if (firstEndChar.equalsIgnoreCase(secondStartChar)) {
                    builder.append(" ").append(list.get(0));
                    list.remove(0);
                    counter--;
                } else if (firstStartChar.equalsIgnoreCase(secondEndChar)) {
                    builder.insert(0, list.get(0) + " ");
                    list.remove(0);
                    counter--;
                } else {
                    String str = list.get(0);
                    list.remove(0);
                    list.add(str);
                    counter++;
                    if (counter > Math.pow(list.size() + 1, 2)) {
                        break;
                    }
                }
            }
            builderList.add(builder);
            builder  = new StringBuilder();
        }
//        builderList.forEach(System.out::println);
       return builderList.stream().max(Comparator.comparingInt(StringBuilder::length)).get();
    }
}
