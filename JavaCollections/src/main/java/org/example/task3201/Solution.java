package org.example.task3201;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File inputFile = new File(resultFileAbsolutePath);
        File newFile = new File(inputFile.getParentFile() + "/allFilesContent.txt");

        if (FileUtils.isExist(new File(resultFileAbsolutePath))) {
            FileUtils.deleteFile(newFile);
        }
            FileUtils.renameFile(inputFile, newFile);

        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(Paths.get(path), myFileVisitor);

        fillFile(new File(resultFileAbsolutePath), myFileVisitor.listFile);
    }

    public static void fillFile(File file, List<File> list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (File listFile : list) {
                if (listFile.length() >= 50){
                    try (FileInputStream fileInputStream = new FileInputStream(listFile)){

                        while (fileInputStream.available() > 0) {
                            fileOutputStream.write(fileInputStream.read());
                        }
                        fileOutputStream.write("/n".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public ArrayList<File> listFile = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.size() >= 50) {
            listFile.add(file.toFile());
        }

        return FileVisitResult.CONTINUE;
    }
}



