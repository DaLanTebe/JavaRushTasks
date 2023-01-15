package com.javarush.task.task20.task2022;

import java.io.*;
import java.util.Objects;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("your_fileName_2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream("your_fileName_2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        Solution solution = new Solution("your_fileName_1.txt");
        solution.writeObject("some_text");

        outputStream.writeObject(solution);
        outputStream.flush();


        Solution loadSolution = (Solution) inputStream.readObject();
        loadSolution.writeObject("some_text2");
    }
}
