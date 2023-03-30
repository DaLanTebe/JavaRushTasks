package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        ConsoleHelper.writeMessage("Введите абсолютный путь с клавиатуры");
        String path = ConsoleHelper.readString();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        ConsoleHelper.writeMessage("Введите путь к файлу который будет архивирован");
        String pathToArchive = ConsoleHelper.readString();
        zipFileManager.createZip(Paths.get(pathToArchive));
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
