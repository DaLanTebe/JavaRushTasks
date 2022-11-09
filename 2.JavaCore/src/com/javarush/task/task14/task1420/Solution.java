package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
//            int first = Integer.parseInt(reader.nextLine());
//            int second = Integer.parseInt(reader.nextLine());
//        System.out.println(first + second);


//            int deli = 2;
//            int count = 0;
//
//            if (first < 1 || second < 1) {
//                throw new Exception();
//            }
//
//            while (deli != first || deli != second) {
//                if (first % deli == 0 && second % deli == 0) {
//                    count = deli;
//                }
//                deli++;
//            }
//            System.out.println(count);

//        BigInteger bigInteger1 = new BigInteger(reader.nextLine());
//        BigInteger bigInteger2 = new BigInteger(reader.nextLine());
//        BigInteger gcd = bigInteger1.gcd(bigInteger2);
//        System.out.println(gcd);
        int num1 = reader.nextInt();
        int num2 = reader.nextInt();
        for (int i = Math.min(num1, num2); i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0){
                System.out.println(i);
                break;
            }
        }

    }
}
