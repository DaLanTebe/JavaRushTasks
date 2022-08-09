package com.javarush.task.pro.task04.task0421;

/* 
Охлаждение ядра планеты
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int sum = 0;
        while (a < 100) {
            a++;
            if (0 == a % 2) {
                sum = sum + a;
            }
        }
        System.out.println(sum);
    }
}