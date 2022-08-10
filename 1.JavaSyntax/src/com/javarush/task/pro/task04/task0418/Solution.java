package com.javarush.task.pro.task04.task0418;

import java.util.Scanner;

/* 
Стакан наполовину пуст или наполовину полон?
*/

public class Solution {
    public static void main(String[] args) {
        double glass = 0.5;
        int c = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        boolean a = scanner.nextBoolean();
        if (a) {
            c = (int) Math.ceil(glass);
            System.out.println(c);
        }else if (!a) {
            b = (int) Math.floor(glass);
            System.out.println(b);
        }
    }
    }

