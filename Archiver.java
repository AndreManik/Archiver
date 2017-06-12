package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Andre on 12.06.2017.
 */
public class Archiver {



    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к файлу архива");

        String fullPath = null;
        try{
            fullPath = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fullPath));
            System.out.println("Что архивировать будем?");
            fullPath = reader.readLine();
            zipFileManager.createZip(Paths.get(fullPath));

            new ExitCommand().execute();

        } catch (Exception NAN){}


    }

}
