package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<>();
        int[] byteArray = new int[256];
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(console.readLine())){
            while (fileInputStream.available() > 0){
                byteArray[fileInputStream.read()]++;
            }
        }
        IntStream.range(0, byteArray.length).filter(i -> byteArray[i] == Arrays.stream(byteArray).max().getAsInt()).forEach(list::add);
        list.forEach(i -> System.out.print(i + " "));
    }
}
