package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF1 = reader.readLine ( );
        String         nameF2 = reader.readLine ( );
        FileInputStream  inputStream  = new FileInputStream ((nameF1));
        FileOutputStream outputStream = new FileOutputStream ((nameF2));
        byte[]           buffer       = new byte[inputStream.available ( )];
        int              count        = inputStream.read (buffer);
        for (int i = 0; i < buffer.length / 2; i++)
            {
                byte tmp = buffer[i];
                buffer[i] = buffer[buffer.length - 1 - i];
                buffer[buffer.length - 1 - i] = tmp;
            }
        outputStream.write (buffer);
        inputStream.close ( );
        outputStream.close ( );
        reader.close ( );
        }
}
