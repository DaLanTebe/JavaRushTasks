package com.javarush.task.jdk13.task41.task4116.visitor;


import com.javarush.task.jdk13.task41.task4116.animals.Cat;
import com.javarush.task.jdk13.task41.task4116.animals.Cow;
import com.javarush.task.jdk13.task41.task4116.animals.Dog;

public interface Visitor {
    String visitCat(Cat cat);
    String visitDog(Dog dog);
    String visitCow(Cow cow);
}
