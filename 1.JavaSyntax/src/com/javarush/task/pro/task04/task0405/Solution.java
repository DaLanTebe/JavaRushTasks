package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        while (a < 10) {
            int d = 0;
            int c =0;
            int b = 0;
            if (a == 0 || a == 9)
                while (b < 20) {
                    System.out.print("Б");
                    b++;
                }else if (a != 0 || a !=9){
                    while (c < 20){
                        if (c == 0 || c == 19) {
                            System.out.print("Б");
                        }else
                                System.out.print(" ");
                        c++;
                    }
            }
            System.out.println("");
            a++;
        }
    }
}