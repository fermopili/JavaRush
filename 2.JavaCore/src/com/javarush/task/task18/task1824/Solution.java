package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader             reader = new BufferedReader (new InputStreamReader (System.in));
        String                     name;
        ArrayList<FileInputStream> list   = new ArrayList<> ( );
        while (!(name = reader.readLine ( )).contains ("exit"))
            {
                try
                    {
                        list.add (new FileInputStream (name));
                    }
                catch (java.io.FileNotFoundException e)
                    {
                        for (FileInputStream f : list)
                            f.close ( );
                        System.out.println (name);
                        break;
                    }

            }

        reader.close ( );
        }
}
