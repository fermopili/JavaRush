package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution
{
    public static List<String> allLines       = new ArrayList<String> ( );
    public static List<String> forRemoveLines = new ArrayList<String> ( );

    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        BufferedReader f1 = new BufferedReader (new FileReader (reader.readLine ( )));
        BufferedReader f2 = new BufferedReader (new FileReader (reader.readLine ( )));
        reader.close ( );
        while (f1.ready ( ))
            {
                allLines.add (f1.readLine ( ));
            }
        f1.close ( );
        while (f2.ready ( ))
            {
                forRemoveLines.add (f2.readLine ( ));
            }

        f2.close ( );
        try
            {
                new Solution ( ).joinData ( );
            }
        catch (CorruptedDataException e)
            {
                e.printStackTrace ( );
            }
        }
    public void joinData() throws IOException
        {
        if (allLines.containsAll (forRemoveLines))
            allLines.removeAll (forRemoveLines);
        else
            {
                allLines.clear ( );
                throw new CorruptedDataException ( );
            }
        }
/*
    private static void printL(List<String> l)
        {
            for(String s:l)
                System.out.println (s);
        }
*/
}
