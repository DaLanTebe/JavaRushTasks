package com.javarush.task.pro.task04.task0408;

import com.sun.jdi.Value;

import java.util.Scanner;

/* 
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int max = Integer.MIN_VALUE;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            if (max < a) {
                if (0 == a % 2) {
                    max = a;
                }
            }
        }
        System.out.println(max);
    }
}