package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        if (0 == array.length % 2) {
            int str = array.length / 2;
            Arrays.fill(array, 0, str, valueStart);
            Arrays.fill(array, str, array.length, valueEnd);
        } else {
            int str = (array.length + 1) / 2;
            Arrays.fill(array, 0, str, valueStart);
            Arrays.fill(array, str,array.length, valueEnd);

        }
        System.out.println(Arrays.toString(array));
    }
}
