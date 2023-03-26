package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int median;
        if (array.length % 2 == 0) {
            int a = array[array.length / 2 - 1];
            int b = array[array.length / 2];
            median = (a + b) / 2;
        } else {
            median = array[array.length / 2];
        }
        Comparator<Integer> comparator = Comparator.comparingInt(e -> Math.abs(median - e));
        Arrays.sort(array, comparator);
        return array;
    }
}
