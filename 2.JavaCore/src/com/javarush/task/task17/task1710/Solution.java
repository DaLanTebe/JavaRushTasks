package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        switch (args[0]) {
            case "-c":
                if (args[2].equalsIgnoreCase("м")) {
                    person = Person.createMale(args[1], inputFormat.parse(args[3]));
                } else if (args[2].equalsIgnoreCase("ж")) {
                    person = Person.createFemale(args[1], inputFormat.parse(args[3]));
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;
            case "-r":
                if ((person = allPeople.get(Integer.parseInt(args[1]))) != null) {
                    String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(person.getName() +
                            " " + sex +
                            " " + outputFormat.format(person.getBirthDate()));
                }
                break;
            case "-u":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person == null) throw new IllegalArgumentException();
                person.setName(args[2]);
                if (args[3].equalsIgnoreCase("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equalsIgnoreCase("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                person.setBirthDate(inputFormat.parse(args[4]));
                break;
            case "-d" :
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person == null) throw new IllegalArgumentException();
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
        }

    }
}
