package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/* 
Что внутри папки?
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        Path path = Paths.get (reader.readLine ( ));
        if (!Files.isDirectory (path))
            {
                System.out.println (path.toString ( ) + " - не папка");
                return;
            }
        // countDirs++;
        // calculate (file);
        //  System.out.println ("Всего папок - [" + countDirs + "]");
        //  System.out.println ("Всего файлов - [" + countFiles + "]");
        //  System.out.println ("Общий размер - [" + size + "]");
        reader.close ( );
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor ( );
        Files.walkFileTree (path, searchFileVisitor);

        long sizeOfFiles    = searchFileVisitor.getSize ( );
        int  numFiles       = searchFileVisitor.getCountFiles ( );
        int  numDirectories = searchFileVisitor.getCountDirs ( );

        System.out.println ("Всего папок - " + (numDirectories-1));
        System.out.println ("Всего файлов - " + numFiles);
        System.out.println ("Общий размер - " + sizeOfFiles);

        }
/*
    static void calculate(File f)
        {
        File[] dirs = f.listFiles ( );
        for (File file : dirs)
            {
                if (file.isDirectory ( ))
                    {
                        countDirs++;
                        calculate (file);
                    }
                else
                    {
                        countFiles++;
                        size += file.length ( );
                    }
            }
        }
*/
}
