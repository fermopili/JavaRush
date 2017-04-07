package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         name1  = reader.readLine ( );
    //    name1 = "c:/1";
        BufferedReader readerF = new BufferedReader (new FileReader (name1));
        StringBuffer   buffer;
        while (readerF.ready ( ))
            {
                String str = readerF.readLine ( );
                buffer = new StringBuffer (str);
                buffer.reverse ( );
                System.out.println (buffer);
            }
        reader.close ( );
        readerF.close ( );
        }
}
