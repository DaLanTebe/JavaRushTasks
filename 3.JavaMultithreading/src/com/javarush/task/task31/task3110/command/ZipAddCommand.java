package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Файл добавлен в архив");
        try {
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полный путь файла для добавления:");
            zipFileManager.addFile(Paths.get(ConsoleHelper.readString()));
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не был найден");
        }
    }
}
