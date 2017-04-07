package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        FileReader              fr      = new FileReader (args[0]);
        BufferedReader          readerF = new BufferedReader (fr);
        TreeMap<String, Double> tree    = new TreeMap<> ( );
        TreeMap<String, Double> treeR   = new TreeMap<> ( );
        while (readerF.ready ( ))
            {
                String   str     = readerF.readLine ( );
                String[] strA    = str.split (" ");
                boolean  replace = false;
                for (Map.Entry<String, Double> pair : tree.entrySet ( ))
                    {
                        String name = pair.getKey ( );
                        if (name.equals (strA[0]))
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
        double summa = 0;
        for (Map.Entry<String, Double> pair : tree.entrySet ( ))
            {
                if (summa < pair.getValue ( ))
                    summa = pair.getValue ( );
            }
        for (Map.Entry<String, Double> pair : tree.entrySet ( ))
            {
                if (new Double (summa).equals (pair.getValue ( )))
                    treeR.put (pair.getKey ( ), pair.getValue ( ));
            }
        for (Map.Entry<String, Double> pair : treeR.entrySet ( ))
            System.out.println (pair.getKey ( ));
        readerF.close ( );
        }
}
