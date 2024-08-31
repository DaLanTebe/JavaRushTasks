package org.example.task3202;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws FileNotFoundException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "r")) {
            randomAccessFile.seek(Math.min(randomAccessFile.length(), Long.parseLong(args[1])));
            randomAccessFile.write(args[2].getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

