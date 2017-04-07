package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {

        //  BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        //  String name1 = reader.readLine ( );
        //  String name2 = reader.readLine ( );
        //  name1 = "c:/1";
        //  name2 = "c:/2";
        BufferedReader readerF = new BufferedReader (new FileReader (args[0]));
        BufferedWriter writerF = new BufferedWriter (new FileWriter (args[1]));
        boolean  isComa = false;
        while (readerF.ready ( ))
            {
                String   str    = readerF.readLine ( );
                String[] sA     = str.split (" ");
                for (String s : sA)
                    {
                        if (s.length ( ) > 6)
                            {
                                if (isComa)
                                    writerF.write (",");
                                writerF.write (s);
                                isComa = true;
                            }
                    }

            }
        // reader.close ( );
        readerF.close ( );
        writerF.close ( );
        }
}
