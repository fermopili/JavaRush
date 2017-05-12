package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Administrator on 05.05.2017.
 */
public class SearchFileVisitor extends SimpleFileVisitor<Path>
{
    public int getCountDirs()
        {
        return countDirs;
        }

    public int getCountFiles()
        {
        return countFiles;
        }

    public long getSize()
        {
        return size;
        }

    private int  countDirs  = 0;
    private int  countFiles = 0;
    private long size       = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
        {
        countDirs++;
        return FileVisitResult.CONTINUE;
        }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
        {
        countFiles ++;
        size+= Files.size(file);
        return FileVisitResult.CONTINUE;
        }
}
