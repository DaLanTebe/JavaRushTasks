package com.javarush.task.pro.task04.task0406;

import java.util.Scanner;

/* 
Показываем, что получаем
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a;
        while (true) {
            a = scanner.nextLine();
            if (a.equals("enough")) {
                break;
            } else
                System.out.println(a);

        }
    }
}