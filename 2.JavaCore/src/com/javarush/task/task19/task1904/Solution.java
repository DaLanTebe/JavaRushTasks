package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] split = line.split(" ");
            String lastName = split[0];
            String firstName = split[1];
            String middleName = split[2];
            int year = Integer.parseInt(split[5]);
            int month = Integer.parseInt(split[4]) - 1;
            int dayOfMonth = Integer.parseInt(split[3]);
            Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
            return new Person(firstName, middleName, lastName, calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
