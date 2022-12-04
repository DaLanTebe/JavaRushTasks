package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = console.readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while (reader.ready()) {
                    list.add(reader.readLine());
                }
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("-u")) {
                    IntStream.range(0, list.size()).filter(i -> list.get(i).substring(0, 8).trim().equals(args[1])).forEach(i -> list.set(i, checkLength(args[1], 8) + checkLength(args[2], 30) + checkLength(args[3], 8) + checkLength(args[4], 4)));
                } else if (args[0].equalsIgnoreCase("-d")) {
                    list.removeIf(str -> str.substring(0, 8).trim().equals(args[1]));
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String string : list) {
                    writer.write(string);
                    writer.newLine();
                }
            }
        }
    }

    public static String checkLength(String string, int limit) {
        StringBuilder builder = new StringBuilder(string);
        if (string.length() > limit) {
            return string.substring(0, limit);
        } else {
            while (builder.length() != limit) {
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
