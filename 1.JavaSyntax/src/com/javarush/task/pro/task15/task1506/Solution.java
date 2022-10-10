package com.javarush.task.pro.task15.task1506;

import javax.imageio.IIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        for (String str : Files.readAllLines(Path.of(new Scanner(System.in).nextLine()))){
            System.out.println(str.replaceAll("[.,\\s]", ""));
        }
    }
}

