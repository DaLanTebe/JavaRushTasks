package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                String string = reader.readLine();
                Movie movie = MovieFactory.getMovie(string);
                if (movie == null){
                    return;
                }
                System.out.println(movie.getClass().getSimpleName());
            }
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equalsIgnoreCase(key)) {
                movie = new Cartoon();
            } else if ("thriller".equalsIgnoreCase(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }
    static class Thriller extends Movie {

    }
}
