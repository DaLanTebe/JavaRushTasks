package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String string;
            while (!(string = console.readLine()).equalsIgnoreCase("exit")) {
                new ReadThread(string).start();
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            Map<Integer, Integer> map = new HashMap<>();
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                while (inputStream.available() > 0) {
                    map.merge(inputStream.read(), 1, Integer::sum);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Integer key = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

            resultMap.put(fileName, key);//максимальный байт этого файла найти в мапе
        }
    }
}
