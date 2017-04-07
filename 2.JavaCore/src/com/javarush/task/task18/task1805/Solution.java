package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF  = reader.readLine ( );
        FileInputStream inputStream = new FileInputStream (nameF);
        List<Integer>   list        = new ArrayList<> ( );
        while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
            {
                int data = Integer.valueOf (inputStream.read ( )); //прочитать очередной байт
                if (!list.contains (data))
                    list.add (data);

            }
        Collections.sort (list);
        for (Integer i : list)
            System.out.print (i + " ");
        reader.close ( );
        inputStream.close ( ); // закрываем поток
        }
}
