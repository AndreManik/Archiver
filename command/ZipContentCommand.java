package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

/**
 * Created by Andre on 12.06.2017.
 */
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Содержимое архива:");
        ZipFileManager zipFileManager = getZipFileManager();

        List<FileProperties> list = zipFileManager.getFilesList();

        for(FileProperties fp : list){
            ConsoleHelper.writeMessage(fp.toString());
        }
    }
}
