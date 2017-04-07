package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF  = reader.readLine ( );
        // nameF="c:\\1";
        FileInputStream inputStream = new FileInputStream (nameF);
        int             count       = 0;
        while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
            {
                byte data = (byte) inputStream.read ( ); //прочитать очередной байт
                if (data == 0x2C)
                    count++;
            }
        System.out.print (count);
        reader.close ( );
        inputStream.close ( ); // закрываем поток
        }
}
