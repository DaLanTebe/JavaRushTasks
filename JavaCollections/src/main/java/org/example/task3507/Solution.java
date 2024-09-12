package org.example.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        HashSet<Animal> set = new HashSet<>();

        File path = new File(pathToAnimals);
        List<File> list = Arrays.stream(path.listFiles()).filter(a -> a.getAbsolutePath().toString().matches("%.class")).toList();

        MyClassLoader myClassLoader = new MyClassLoader();
        for (File file : list) {
            Class<? extends Animal> loaderClass = (Class<? extends Animal>) myClassLoader.findClass(file.getName());
            for (Constructor constructor : loaderClass.getConstructors()){
                if (constructor.getModifiers() == 1 && constructor.getParameterCount() == 0 && loaderClass.isAssignableFrom(Animal.class)){
                    set.add(loaderClass.newInstance());
                }
            }
        }

        return set;
    }
    private static class MyClassLoader extends ClassLoader{
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}

