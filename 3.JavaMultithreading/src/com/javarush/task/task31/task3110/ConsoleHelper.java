package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(readString().trim());
    }
}
