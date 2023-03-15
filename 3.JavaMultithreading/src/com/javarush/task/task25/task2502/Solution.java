package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            String[] strings = loadWheelNamesFromDB();
            if (Objects.isNull(strings)) throw new RuntimeException();
            for (int i = 0; i < strings.length; i++) {
               try {
                   wheels.add(Wheel.valueOf(strings[i]));
               }catch (Exception e){
                   throw new RuntimeException();
               }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
