package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        multiArray = new int[a][];
        for (int i = 0; i < multiArray.length; i++) {
            int b = scanner.nextInt();
            multiArray[i] = new int[b];
        }
    }
}
