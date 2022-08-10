package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int radius = scanner.nextInt();
        double pi = 3.14;
        double S = pi * radius * radius;
        int result = (int) Math.floor(S);
        System.out.println(result);

    }
}