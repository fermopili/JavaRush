package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        String          nameF       = args[0];
        FileInputStream inputStream = new FileInputStream (nameF);
        double          space       = 0;
        double          simbol      = 0;
        while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
            {
                char data = (char) inputStream.read ( ); //прочитать очередной байт
                simbol++;
                if (data == 0x20)
                    space++;
            }
        inputStream.close ( ); // закрываем поток
        System.out.println (String.format ("%.2f", space / simbol * 100.)); //выводим  на экран.
        }

}
