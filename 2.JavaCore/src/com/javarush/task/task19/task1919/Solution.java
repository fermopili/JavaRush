package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        ArrayList<String>       list       = new ArrayList<String> ( );
        BufferedReader          fileReader = new BufferedReader (new FileReader (args[0]));
        TreeMap<String, Double> tree       = new TreeMap<> ( );
        while (fileReader.ready ( ))
            {
                String   str     = fileReader.readLine ( );
                String[] strA    = str.split (" ");
                boolean  replace = false;
                for (Map.Entry<String, Double> pair : tree.entrySet ( ))
                    {
                        String name = pair.getKey ( );
                        if (name.contains (strA[0]))
                            {
                                double d = pair.getValue ( );
                                d += Double.parseDouble (strA[1]);
                                tree.replace (name, d);
                                replace = true;
                                break;

                            }
                    }
                if (!replace)
                    tree.put (strA[0], Double.parseDouble (strA[1]));
            }
        for (Map.Entry<String, Double> pair : tree.entrySet ( ))
            System.out.println (pair.getKey ( ) + " " + pair.getValue ( ));
        fileReader.close ( );
        }
}
