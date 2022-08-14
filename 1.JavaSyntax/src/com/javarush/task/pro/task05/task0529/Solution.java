package com.javarush.task.pro.task05.task0529;

import java.util.Arrays;

/* 
Галаксианские роботанки (1)
*/

public class Solution {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";
    public static int width = 30;
    public static int height = 10;
    public static String[][] array = new String[width][height];
    public static String[][] field = new String[height][width];

    public static void main(String[] args) {
        int n = width;
        for (int i = 0; i < field.length; i++) {
            int x = (int) (Math.random() * n);
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = empty;
                if (j == x){
                    field[i][j] = robotank;
                }
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
}