package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
c:/tmp/fileTest.txt.part1
c:/tmp/fileTest.txt.part3
c:/tmp/fileTest.txt.part5
c:/tmp/fileTest.txt.part4
c:/tmp/fileTest.txt.part2
end
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader    reader = new BufferedReader (new InputStreamReader (System.in));
        String            name;
        ArrayList<String> list   = new ArrayList<> ( );
        while (!(name = reader.readLine ( )).contains ("end"))
            {
                list.add (name);
            }
        Collections.sort (list);
        String nameNewFile = list.get (0);
        int pos=nameNewFile.lastIndexOf (".");
        nameNewFile = nameNewFile.substring (0, pos);
        FileOutputStream outputStream = new FileOutputStream (nameNewFile);
        byte[] buffer=new byte[1024];
        for (String nameFilePart : list)
            {
                FileInputStream inputStream = new FileInputStream (nameFilePart);
                while (inputStream.available ( ) > 0)
                    {   int    count  = inputStream.read (buffer);
                        outputStream.write (buffer, 0, count);
                    }
                inputStream.close ( );
            }
        outputStream.close ();
        reader.close ( );
        }
}
