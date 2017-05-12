package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
        {
        File        file  = new File (root);
        Queue<File> paths = new PriorityQueue<> ( );
        Collections.addAll (paths, file.listFiles ( ));
        List<String> result = new ArrayList<> ( );
        while (!paths.isEmpty ( ))
            {
                File checkFile = paths.poll ( );
                if (checkFile.isDirectory ( ))
                    Collections.addAll (paths, checkFile.listFiles ( ));
                else result.add (checkFile.getAbsolutePath ( ));
            }
        return result;


        }

    public static void main(String[] args) throws IOException
        {
       System.out.println ( getFileTree("e:\\video"));
        }
}
