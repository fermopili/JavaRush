package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        String nameF = args[0];
        FileInputStream inputStream = new FileInputStream (nameF);
        int c=0;
        while (inputStream.available ( )>0) //пока остались непрочитанные байты
            {
                char data = (char)inputStream.read ( ); //прочитать очередной байт
                if(((data>='a')&(data<='z'))||((data>='A')&(data<='Z')))
                    c++;
            }
        inputStream.close ( ); // закрываем поток
        System.out.println (c); //выводим  на экран.
        }
}
