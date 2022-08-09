package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String enter = "ENTER";
        boolean Enter = false;
        while (true) {
            int a = scanner.nextInt();
            sum += a;
            if (scanner.hasNextLine())

        }
        System.out.println(sum);
    }
}