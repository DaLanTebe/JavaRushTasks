package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b;
        int min = scanner.nextInt();
        int secondMin = scanner.nextInt();
        if (min > secondMin) {
           int a = min;
            min = secondMin;
            secondMin = a;
        }
        while (scanner.hasNextInt()) {
            b = scanner.nextInt();
            if (min == secondMin){
                if (b < min){
                    min = b;
            }else {
                    secondMin = b;
                }
            } else if (min > b) {
                secondMin = min;
                min = b;
            } else if (min < b && b < secondMin)
                secondMin = b;
        }
        System.out.println(secondMin);
    }
}
