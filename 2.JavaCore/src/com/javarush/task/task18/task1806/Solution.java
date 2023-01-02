package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       try (FileInputStream inputStream = new FileInputStream("c:/data.txt");
            FileOutputStream outputStream = new FileOutputStream("c:/result.txt")){
           // Создаем поток-записи-байт-в-файл

           if (inputStream.available() > 0) {
               //читаем весь файл одним куском
               byte[] buffer = new byte[inputStream.available()];
               int count = inputStream.read(buffer);
               outputStream.write(buffer, 0, count);
           }
       }
    }
}