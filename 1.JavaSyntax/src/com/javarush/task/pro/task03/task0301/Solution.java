package com.javarush.task.pro.task03.task0301;

import java.util.Scanner;

/* 
Тепло или холодно
*/

public class Solution {
    public static void main(String[] args) {
        String cold = "на улице холодно";
        String warm = "на улице тепло";
        Scanner abc = new Scanner(System.in);
        int a = abc.nextInt();
        if (a >= 0)
        System.out.println("на улице тепло");
        else
            System.out.println("на улице холодно");
    }
}
