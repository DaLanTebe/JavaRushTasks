package org.example.smth;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] ints = new int[1000000];
        for (int i = 0; i < ints.length - 1; i++) {
            ints[i] = (int) (Math.random() * 10000);
        }
        ints[100001] = 8;
        Arrays.sort(ints);
//        System.out.println(STR."\{binarySearch(ints, 8, 0, ints.length - 1)} \{System.currentTimeMillis()}");
    }
    private static int binarySearch (int[] sortedArray, int valueToFind, int low, int high){
        int index = -1;

        while (low <= high){
            int mid = low + (high - low)  / 2;
            if (sortedArray[mid] < valueToFind){
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }

        return index;
    }
}
