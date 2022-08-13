package com.javarush.task.pro.task05.task0526;

/* 
Атака вирусов
*/

public class Solution {
    public static int[][] array = {{3, 2, 1, 4}, {2, 3, 4, 5}, {5, 3, 2, 1}};

    public static void main(String[] args) {
        int[] tmp = array[0];
        array[0] = array[2];
        array[2] = tmp;
    }

}
