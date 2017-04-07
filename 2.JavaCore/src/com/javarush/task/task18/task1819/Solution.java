package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         name1  = reader.readLine ( );
        String         name2  = reader.readLine ( );
        //name1 = "c:/1.txt";
        //name2 = "c:/2.txt";
        FileInputStream f1_in = new FileInputStream (name1);
        byte[]          b1    = new byte[f1_in.available ( )];
        int             c1    = f1_in.read (b1);
        f1_in.close ( );
        FileOutputStream f1_out = new FileOutputStream (name1);
        FileInputStream  f2     = new FileInputStream (name2);
        byte[]           b      = new byte[f2.available ( )];
        int              c      = f2.read (b);
        f1_out.write (b, 0, c);
        f1_out.write (b1, 0, c1);
        f2.close ( );
        f1_out.close ( );
        reader.close ( );
        }
}
