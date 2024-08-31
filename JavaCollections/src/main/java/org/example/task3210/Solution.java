package org.example.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String text = args[2];
        try (RandomAccessFile file = new RandomAccessFile(args[0], "rw")){
            file.seek(Long.parseLong(args[1]));
            byte[] bytes = new byte[text.length()];
            file.read(bytes, 0 , text.length());

            String s = new String(bytes);
            file.seek(file.length());

            if (s.equals(text)){
                file.write("true".getBytes());
            }else {
                file.write("false".getBytes());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
