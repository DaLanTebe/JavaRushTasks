package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer1 = new FileWriter(console.readLine());
        BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()));
        BufferedReader reader3 = new BufferedReader(new FileReader(console.readLine()));){
            while (reader2.ready()){
                writer1.write(reader2.readLine());
            }
            while (reader3.ready()){
                writer1.write(reader3.readLine());
            }
        }
    }
}
