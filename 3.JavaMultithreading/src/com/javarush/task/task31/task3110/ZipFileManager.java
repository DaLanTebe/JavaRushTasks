package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        if (!Files.exists(zipFile.getParent())){
            Files.createDirectory(zipFile.getParent());
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))){
            if (Files.isRegularFile(source)){
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                for (Path fileName : new FileManager(source).getFileList()) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }
    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))){
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    public List<FileProperties> getFilesList() throws Exception{
        if (!Files.isRegularFile(zipFile)){
           throw new WrongZipFileException();
        }
        List<FileProperties> fileProperties = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))){
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            while (nextEntry != null){
                nextEntry = zipInputStream.getNextEntry();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                copyData(zipInputStream, stream);

                FileProperties fileProperties1 = new FileProperties(nextEntry.getName(), nextEntry.getSize(), nextEntry.getCompressedSize(), nextEntry.getMethod());
                fileProperties.add(fileProperties1);
            }
        }
        return fileProperties;
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
