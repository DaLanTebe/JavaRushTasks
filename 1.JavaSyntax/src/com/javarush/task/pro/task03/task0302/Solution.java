package com.javarush.task.pro.task03.task0302;

import java.util.Scanner;

/* 
Призывная кампания
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String militaryCommissar = name + ", явитесь в военкомат";
        int age = scanner.nextInt();
        if (age >= 18 && age <= 28)
            System.out.println(militaryCommissar);

    }
}
