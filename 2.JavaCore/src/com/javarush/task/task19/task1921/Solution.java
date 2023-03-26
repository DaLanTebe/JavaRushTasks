package com.javarush.task.task19.task1921;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
//            while (reader.ready()) {
//                String string = reader.readLine();
//                String name = string.replaceAll("\\d", "").trim();
//                String date = string.replaceAll("\\D", " ").trim();
//                PEOPLE.add(new Person(name, dateFormat.parse(date)));
//            }
//        }
//        PEOPLE.forEach(person -> System.out.println(person.getName() + " " + person.getBirthDate()));
        Files.readAllLines(Path.of(args[0])).stream()
                .map(str -> new Person(
                        str.replaceAll("\\d", "").trim(),
                        Date.from(LocalDate.parse(str.replaceAll("\\D", " ").trim(), DateTimeFormatter.ofPattern("dd M yyyy")).atStartOfDay(ZoneId.systemDefault()).toInstant())
                )).peek(PEOPLE::add).forEach(person -> System.out.println(person.getName() + " " + person.getBirthDate()));
    }
}
