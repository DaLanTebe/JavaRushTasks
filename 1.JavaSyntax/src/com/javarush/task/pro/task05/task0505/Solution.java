package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        if (n % 2 == 0) {
            for (int j = array.length - 1; j >= 0; j--) {
                System.out.println(array[j]);
            }
        } else {
            for (int k = 0; k < array.length; k++) {
                System.out.println(array[k]);
            }
        }
    }
}
