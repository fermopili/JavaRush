package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF  = reader.readLine ( );
        FileInputStream           inputStream = new FileInputStream (nameF);
        HashMap<Integer, Integer> map         = new HashMap<> ( );
        int                       min         = inputStream.available ( );
        while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
            {
                int data = Integer.valueOf (inputStream.read ( )); //прочитать очередной байт
                if (map.containsKey (data))
                    {
                        int value = map.get (data);
                        map.replace (data, value + 1);
                    }
                else
                    {
                        map.put (data, 1);
                    }
            }
        Iterator it = map.entrySet ( ).iterator ( );
        while (it.hasNext ( ))
            {
                HashMap.Entry pair  = (Map.Entry) it.next ( );
                int           value = (int) pair.getValue ( );
                if (value < min)
                    min = value;
            }
        Iterator it1 = map.entrySet ( ).iterator ( );
        while (it1.hasNext ( ))
            {
                HashMap.Entry pair = (Map.Entry) it1.next ( );
                if (pair.getValue ( ).equals (min))
                    System.out.print (pair.getKey ( ) + " ");
            }
        reader.close ( );
        inputStream.close ( ); // закрываем поток
        }
}
