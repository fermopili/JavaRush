package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader=new BufferedReader (new InputStreamReader (System.in));
        String nameF=reader.readLine ();
         FileInputStream inputStream = new FileInputStream (nameF);
        int max=0;
        while (inputStream.available ( )>0) //пока остались непрочитанные байты
            {
                int data = inputStream.read ( ); //прочитать очередной байт
                if(data>max)
                    max=data;
            }
        reader.close ();
        inputStream.close ( ); // закрываем поток
        System.out.println (max); //выводим сумму на экран.
        }
}
