package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                result[i][j] = i + j;
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
