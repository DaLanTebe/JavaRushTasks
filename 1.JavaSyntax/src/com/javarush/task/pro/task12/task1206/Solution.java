package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        int counter = 0;
        for (char aChar : string.toCharArray()) {
            if (Character.isDigit(aChar)){
                counter++;
            }
        }
        return counter;
    }

    public static int countLetters(String string) {
        int counter = 0;
        for (char aChar : string.toCharArray()) {
            if (Character.isLetter(aChar)){
                counter++;
            }
        }
        return counter;
    }

    public static int countSpaces(String string) {
        int counter = 0;
        for (char aChar : string.toCharArray()) {
            if (Character.isSpaceChar(aChar)){
                counter++;
            }
        }
        return counter;
    }
}
