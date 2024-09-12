package org.example.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/*
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File path = new File(pathToAnimals);
        File[] files = path.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        HashSet<Animal> ts = new HashSet<>();
        return ts;
    }
}

