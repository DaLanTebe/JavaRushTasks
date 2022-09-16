package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                for (int j = i; j < array.length; j++) {
                 if (array[j] != null){
                     array[i] = array[j];
                     array[j] = null;
                     break;
                 }
                }
            }
        }
    }
}
