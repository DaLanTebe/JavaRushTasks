package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();

        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("");

        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while (reader.ready()){
            System.out.println(reader.readLine());
        }

    }
}

