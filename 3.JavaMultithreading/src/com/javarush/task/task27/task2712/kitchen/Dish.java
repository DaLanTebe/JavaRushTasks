package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;
    public static String allDishesToString(){
        StringBuilder builder = new StringBuilder();
        for (Dish value : values()){
            builder.append(value).append(", ");
        }
        return builder.toString().trim().substring(0 , builder.length() - 1);
    }
}
