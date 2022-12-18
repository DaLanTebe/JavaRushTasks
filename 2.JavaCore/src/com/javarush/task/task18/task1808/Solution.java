package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerFile1 = new FileInputStream(console.readLine());
        FileOutputStream writerFile2  = new FileOutputStream(console.readLine());
        FileOutputStream writerFile3  = new FileOutputStream(console.readLine())){
            int halfFile = (readerFile1.available() + 1) / 2;
            int count = 0;
            while (readerFile1.available() > 0){
                if (count < halfFile){
                    writerFile2.write(readerFile1.read());
                    count ++;
                } else writerFile3.write(readerFile1.read());
            }
        }
    }
}
