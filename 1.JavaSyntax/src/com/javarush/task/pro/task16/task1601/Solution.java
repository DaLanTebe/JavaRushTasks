package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(102, Calendar.JULY, 19);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String result = "";
        switch (date.getDay()){
            case 0 -> result = "Воскресенье";
            case 1 -> result = "Понедельник";
            case 2 -> result = "Вторник";
            case 3 -> result = "Среда";
            case 4 -> result = "Четверг";
            case 5 -> result = "Пятница";
            case 6 -> result = "Суббота";
        }
        return result;
    }
}
