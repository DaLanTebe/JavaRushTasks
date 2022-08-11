package com.javarush.task.pro.task04.task0425;

/* 
Диггер (1)
*/

public class Solution {
    public static String bug = "🐛";
    public static String robot = "🤖";
    public static String land = "🌍";
    public static String death = "💀";
    public static String hole = " ";


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i == 8 && k == 3){
                    System.out.print(robot);
                }else if (k == 3 && i != 9){
                    System.out.print(hole);
                }
                else if (i == 9){
                    System.out.print(bug);
                }else {
                    System.out.print(land);
                }
            }
        System.out.println("");
        }
        }
    }