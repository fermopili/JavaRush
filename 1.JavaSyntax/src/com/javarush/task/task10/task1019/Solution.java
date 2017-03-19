package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader           reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map    = new HashMap<>();
        while (true)
            {
                int id = Integer.parseInt(reader.readLine());
                String name=reader.readLine();
                System.out.println("Id=" + id + " Name=" + name);
                if (name.length() == 0)
                    break;
                map.put( name,id);

            }
        for (Map.Entry< String,Integer> pair :map.entrySet())
            {
                 String name  = pair.getKey();
                int    id = pair.getValue();
                System.out.println("Id=" + id + " Name=" + name);
            }

        }

}

