package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2002, Calendar.JUNE, 19);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        Date date = calendar.getTime();
        String dat = "";
        switch (date.getDay()){
            case (0) -> dat = "Воскресенье";
            case (1) -> dat = "Понедельник";
            case (2) -> dat = "Вторник";
            case (3) -> dat = "Среда";
            case (4) -> dat = "Четверг";
            case (5) -> dat = "Пятница";
            case (6) -> dat = "Суббота";
        }

        return dat;
    }
}
