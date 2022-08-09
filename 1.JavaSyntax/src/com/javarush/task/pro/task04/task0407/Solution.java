package com.javarush.task.pro.task04.task0407;

/* 
Сумма чисел, не кратных 3
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int sum = 0;
        while (a < 100){
            a++;
            if (0 == a % 3) {
                continue;
            }else {
                sum = sum + a;
            }
        }
        System.out.println(sum);

        }
    }
