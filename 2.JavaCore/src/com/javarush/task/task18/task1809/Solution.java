package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(console.readLine());
             FileOutputStream outputStream = new FileOutputStream(console.readLine())) {
            List<Integer> list = new ArrayList<>();
            while (inputStream.available() > 0){
                list.add(inputStream.read());
            }
            Collections.reverse(list);
            for (Integer integer : list) {
                try {
                    outputStream.write(integer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
