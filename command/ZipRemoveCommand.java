package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

/**
 * Created by Andre on 12.06.2017.
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Какой файл удалять будем?");
        zipFileManager.removeFile(Paths.get(ConsoleHelper.readString()));


    }
}
