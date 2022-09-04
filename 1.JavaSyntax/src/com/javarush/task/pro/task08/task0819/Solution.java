package com.javarush.task.pro.task08.task0819;

import java.lang.reflect.Field;
import java.util.Random;

/* 
Амиголятор и Био-диего
*/

import static com.javarush.task.pro.task08.task0819.CosmicAnomaly.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int number = 0;
        int result = 0;
        do {
            number = random.nextInt(upperBound - lowerBound) + lowerBound;
            result = nextAttempt(number);
        } while (number != result);

//           Field declaredField = CosmicAnomaly.class.getDeclaredField("rightNumber");
//
//            declaredField.setAccessible(true);
//            int number2 = (int) declaredField.get(new CosmicAnomaly());
//
//            if (number == number2) {
//                break;
//            }
    }
}


