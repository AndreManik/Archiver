package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Andre on 12.06.2017.
 */
public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile){
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{

        if (Files.notExists(zipFile.getParent())){
            Files.createDirectories(zipFile.getParent());
        }

        try (
                ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
        ){
            if (Files.isRegularFile(source))
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            else if (Files.isDirectory(source)){
                FileManager fileManager = new FileManager(source);
                List<Path> listFiles = fileManager.getFileList();

                for(Path fileName : listFiles){
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }

    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{

        Path fullPath = filePath.resolve(fileName);

        try(InputStream inputStream = Files.newInputStream(fullPath)){
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();

        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception{
        byte[] buffer = new byte[8 * 1024];
        int lenBuff = 0;

        while((lenBuff = in.read(buffer)) > 0){
            out.write(buffer, 0, lenBuff);
        }

    }

}
