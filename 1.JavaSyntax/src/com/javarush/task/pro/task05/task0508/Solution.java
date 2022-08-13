package com.javarush.task.pro.task05.task0508;

import java.util.Arrays;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        strings = new String[6];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[0].equals(strings[i])) {
                strings[0].equals(null);
                continue;
            }
            if (strings[1].equals(strings[i])) {
                strings[1].equals(null);
                continue;
            }
            if (strings[2].equals(strings[i])) {
                strings[2].equals(null);
                continue;
            }
            if (strings[3].equals(strings[i])) {
                strings[3].equals(null);
                continue;
            }
            if (strings[4].equals(strings[i])) {
                strings[4].equals(null);
                continue;
            }
            if (strings[5].equals(strings[i])) {
                strings[5].equals(null);
                continue;
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
