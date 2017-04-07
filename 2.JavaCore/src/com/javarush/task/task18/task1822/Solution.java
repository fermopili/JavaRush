package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         name   = reader.readLine ( );
      //  name = "c:/1.txt";
        int            id     = Integer.parseInt (args[0]);
        BufferedReader br = new BufferedReader (new FileReader (name));
        String         sb;
        while ((sb = br.readLine ( )) != null)
            {
                int pos = sb.toString ( ).indexOf (32);

                if (Integer.parseInt (sb.toString ( ).substring (0, pos)) == id)
                    {
                        System.out.println (sb.toString ( ));
                        break;
                    }
            }
        br.close ( );
        reader.close ( );
        }
}
