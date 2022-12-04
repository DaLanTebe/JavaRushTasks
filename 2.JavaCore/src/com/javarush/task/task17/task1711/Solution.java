package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        switch (args[0]) {
            case "-c" -> {
                synchronized (allPeople) {
                    for (int i = 2; i < args.length; i += 3) {
                        if (args[i].equalsIgnoreCase("м")) {
                            person = Person.createMale(args[i - 1], dateFormat.parse(args[i + 1]));
                        } else if (args[i].equalsIgnoreCase("ж")) {
                            person = Person.createFemale(args[i - 1], dateFormat.parse(args[i + 1]));
                        }
                        if (!allPeople.contains(person) && person != null) {
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                }
                break;
            }
            case "-u" -> {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        if (person == null) throw new IllegalArgumentException();
                        person.setName(args[i + 1]);
                        if (args[i + 2].equalsIgnoreCase("м")) {
                            person.setSex(Sex.MALE);
                        } else if (args[i + 2].equalsIgnoreCase("ж")) {
                            person.setSex(Sex.FEMALE);
                        }
                        person.setBirthDate(dateFormat.parse(args[i + 3]));
                    }
                }
                break;
            }
            case "-d" -> {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        if (person == null) throw new IllegalArgumentException();
                        person.setBirthDate(null);
                        person.setName(null);
                        person.setSex(null);
                    }
                }
                break;
            }
            case "-i" -> {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        if (person == null) throw new IllegalArgumentException();
                        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                        System.out.println(person.getName() +
                                " " + sex +
                                " " + outFormat.format(person.getBirthDate()));
                    }
                }
                break;
            }
        }
    }
}
