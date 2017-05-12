package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path>
{

    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = -1;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
        {
        boolean      containsPartOfName = file.getFileName ( ).toString ( ).contains (partOfName);
        boolean      sizeInDiapazone    = attrs.size ( ) > minSize && attrs.size ( ) < maxSize;
        List<String> lines              = Files.readAllLines (file);
        boolean      containsContent    = false;
        for (String s : lines)
            {
                if (s.contains (partOfContent))
                    {
                        containsContent = true;
                        break;
                    }
            }

        if (containsPartOfName && sizeInDiapazone && containsContent)
            foundFiles.add (file);
        return super.visitFile (file, attrs);

        }


    public void setPartOfName(String partOfName)
        {
        this.partOfName = partOfName;
        }

    public void setPartOfContent(String partOfContent)
        {
        this.partOfContent = partOfContent;
        }

    public void setMinSize(int minSize)
        {
        this.minSize = minSize;
        }

    public void setMaxSize(int maxSize)
        {
        this.maxSize = maxSize;
        }

    public List<Path> getFoundFiles()
        {
        return foundFiles;
        }
}
