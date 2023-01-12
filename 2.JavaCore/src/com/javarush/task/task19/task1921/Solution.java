package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String[] strings = reader.readLine().split(" ");
                for (String string : strings) {

                }
                PEOPLE.add(new Person());
            }
        }
    }
}
