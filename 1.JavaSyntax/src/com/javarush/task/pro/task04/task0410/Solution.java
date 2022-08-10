package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = scanner.nextInt();
        int secondMin = scanner.nextInt();
        if (min > secondMin) {
            int a = min;
            min = secondMin;
            secondMin = a;
        }
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (min == secondMin) {
                if (number < min) {
                    min = number;
                } else {
                    secondMin = number;
                }
            } else if (min > number) {
                secondMin = min;
                min = number;
            } else if (min < number && number < secondMin)
                secondMin = number;
        }
        System.out.println(secondMin);
    }
}
