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
    public static int[][] bombs = new int[height][width];

    public static void main(String[] args) {
        int n = width;

        for (int i = 0; i < field.length; i++) {
            int x = (int) (Math.random() * n);
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = empty;
                if (j == x) {
                    field[i][j] = robotank;
                }
            }
        }
        int countOfTanks = 10;
        while (countOfTanks > 0) {
            for (int k = 0; k < bombs.length; k++) {
                int countOfBombs = 10;
                while (countOfBombs > 0) {
                    int a = (int) (Math.random() * width);
                    if (bombs[k][a] == 0) {
                        bombs[k][a] = 1;
                        countOfBombs--;
                    }
                }
            }
            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[j].length; k++) {
                    if (field[j][k].equals(robotank) && bombs[j][k] == 1) {
                        field[j][k] = hit;
                        countOfTanks--;
                    }
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
}