package com.javarush.task.jdk13.task41.task4116.visitor;

import com.javarush.task.jdk13.task41.task4116.animals.Cat;
import com.javarush.task.jdk13.task41.task4116.animals.Cow;
import com.javarush.task.jdk13.task41.task4116.animals.Dog;

public class YamlExportVisitor implements Visitor {
    @Override
    public String visitCat(Cat cat) {
        return "--- ! <Cat>\n" +
                "name: \"" + cat.getName() + "\"\n" +
                "mice: " + cat.miceCaught() +"\n" +
                "KilogramsOfFur: " + cat.furEaten();
    }

    @Override
    public String visitDog(Dog dog) {
        return "--- ! <Dog>\n" +
                "name: \"" + dog.getName() + "\"\n" +
                "bones: " + dog.bonesGnawed();
    }

    @Override
    public String visitCow(Cow cow) {
        return "--- ! <Cow>\n" +
                "name: \"" + cow.getName() + "\"\n" +
                "litersOfMilk: " + cow.milkedLiters() + "\n" +
                "stars: " + cow.getStars();
    }
}
