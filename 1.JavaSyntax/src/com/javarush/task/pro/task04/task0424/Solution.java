package com.javarush.task.pro.task04.task0424;

import java.util.Scanner;

/* 
Бомба в ядре планеты
*/

public class Solution {
    public static void main(String[] args) {
        Scanner bombInterface = new Scanner(System.in);
        int a;
        do {
            a = bombInterface.nextInt();
            System.out.println(a);
        }while (!(0 == a % 10));
    }
}
