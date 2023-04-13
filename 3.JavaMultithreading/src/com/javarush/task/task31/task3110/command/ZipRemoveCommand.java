package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Из какого архива и какой файл будем удалять");
        zipFileManager.removeFile(Paths.get(ConsoleHelper.readString()));
        ConsoleHelper.writeMessage("Файл был удален");
    }
}
