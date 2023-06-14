package com.javarush.task.task29.task2913;


import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween1 (int a, int b) {
        StringBuilder builder = new StringBuilder();
        if (b > a){
            IntStream.rangeClosed(a, b).forEach(value -> builder.append(value).append(" "));
            return builder.toString().trim();
        }  if (b < a) {
            for (int i = a; i >= b; i--) {
                builder.append(i).append(" ");
            }
            return builder.toString().trim();
        }
        return Integer.toString(a);
    }

    public static String getAllNumbersBetween(int a, int b){
       return b > a ?
               IntStream.rangeClosed(a, b).mapToObj(i -> i + " ").collect(Collectors.joining()).trim() :
               IntStream.iterate(a, i -> i >= b, i -> i - 1).mapToObj(i -> i + " ").collect(Collectors.joining()).trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}