package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(console.readLine());
             InputStreamReader inputStreamReader = new InputStreamReader(stream);
             BufferedReader reader = new BufferedReader(inputStreamReader)
        ){
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
        }
    }
}