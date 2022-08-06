package com.javarush.task.pro.task02.task0214;

import java.util.Scanner;

/* 
Чтение и преобразование строк
*/

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine().toLowerCase();
        String second = scanner.nextLine().toUpperCase();
        String third = scanner.nextLine();
        System.out.println(third);
        System.out.println( );
        System.out.println(second);
        System.out.println();
        System.out.println(first);

    }
}
