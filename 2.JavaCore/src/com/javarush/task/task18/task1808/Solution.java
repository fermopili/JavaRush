package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF1 = reader.readLine ( );
        String         nameF2 = reader.readLine ( );
        String         nameF3 = reader.readLine ( );
      //   nameF1 = "c:\\1";
      //  nameF2 = "c:\\11copy";
      //  nameF3 = "c:\\12copy";
        FileInputStream  inputStream   = new FileInputStream (nameF1);
        FileOutputStream outputStream1 = new FileOutputStream (nameF2);
        FileOutputStream outputStream2 = new FileOutputStream (nameF3);
        byte[]           buffer        = new byte[inputStream.available ( )];
        int              count         = inputStream.read (buffer);
        int midle=  count/2;
        if((count % 2)!=0)
            midle++;
        outputStream1.write (buffer, 0, midle);
        outputStream2.write (buffer, midle, count - midle);
        inputStream.close ( );
        outputStream1.close ( );
        outputStream2.close ( );
        reader.close ( );
        }
}
