package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Andre on 12.06.2017.
 */
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Введите имя архива (полный путь):");
        String fullPathString = ConsoleHelper.readString();
        Path fullPath = Paths.get(fullPathString);

        ZipFileManager zipFileManager = new ZipFileManager(fullPath);

        return zipFileManager;
    }
}
