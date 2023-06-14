package com.javarush.task.task29.task2913;


import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder builder = new StringBuilder();
        if (b > a){
            builder.append(a);
            a++;
            while (b >= a){
                builder.append(" ").append(a);
                a++;
            }
            return builder.toString();
        }  if (b < a) {
            builder.append(a);
            a--;
            while (a >= b){
                builder.append(" ").append(a);
                a--;
            }
            return builder.toString();
        }
        return Integer.toString(a);
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}