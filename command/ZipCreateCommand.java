package com.javarush.task.task31.task3110.command;


import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Andre on 12.06.2017.
 */
public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {

        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Чего архивировать будем (полный путь):");
            Path toArchive = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(toArchive);
            ConsoleHelper.writeMessage("Архив создан.");
        }catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
