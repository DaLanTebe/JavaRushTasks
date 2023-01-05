package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = console.readLine();
            String file2 = console.readLine();
            try (FileInputStream inputStream1 = new FileInputStream(file1);
                 FileInputStream inputStream2 = new FileInputStream(file2)){
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                while (inputStream2.available() > 0){
                    outputStream.write(inputStream2.read());
                }
                while (inputStream1.available() > 0){
                    outputStream.write(inputStream1.read());
                }
                try (FileOutputStream fileOutputStream = new FileOutputStream(file1)){
                    outputStream.writeTo(fileOutputStream);
                }
            }
        }
    }
}
