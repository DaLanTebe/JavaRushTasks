package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            TreeMap<Integer, String> map = new TreeMap<>();
            while (true){
                String fileName = console.readLine();
                if (fileName.equalsIgnoreCase("end")){
                    break;
                }
                int index = Integer.parseInt(fileName.substring(fileName.lastIndexOf("t") + 1));
                if(!map.containsKey(index)){
                    map.put(index, fileName);
                }
            }
            for (String fileName : map.values()) {
                String shortName = fileName.substring(0, fileName.lastIndexOf("."));
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(shortName))){
                    while (inputStream.available() > 0){
                        outputStream.write(inputStream.read());
                    }
                }
            }
        }
    }
}
