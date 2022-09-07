package com.javarush.task.pro.task09.task0924;

/* 
Взлом Стального Стива
*/

import java.util.Arrays;

public class Solution {

    public static String[][] morals = {{"iAmAKiller", "iAmAThief", "honesty", "responsibility", "iAmABully"},
            {"BuLLyIAmA", "honesty", "iamakiller", "iamathief", "responsibility"},
            {"honesty", "iamabully", "responsibility", "AthiefIAm", "ikillerAmA"},
    };

    public static void main(String[] args) {

        cleanMorals();
        for (String[] strings : morals) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public static void cleanMorals() {
        for (int i = 0; i < morals.length; i++) {
            for (int j = 0; j < morals[i].length; j++) {
                String string = morals[i][j].toLowerCase();

                if (string.contains("killer")) {
                    int start = string.indexOf("killer");
                    int end = start + "killer".length();
                    String str = string.substring(start, end);
                    morals[i][j] = string.replace(str, "compassion");
                } else if (string.contains("thief")) {
                    int start = string.indexOf("thief");
                    int end = start + "thief".length();
                    String str = string.substring(start, end);
                    morals[i][j] = string.replace(str, "fairness");
                }
            }
        }

    }

}