package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution
{
    public static void main(String[] args)
        {

        }

    public static String getQuery(Map<String, String> params)
        {
        StringBuilder sb = new StringBuilder ( );
        for (Map.Entry pair : params.entrySet ( ))
            {
                String s1 = (String) pair.getKey ( );
                String s2 = (String) pair.getValue ( );
                if (s2 != null)
                    {
                        if (sb.length ( ) != 0)
                            sb.append (" and ");
                        sb.append (s1).append (" = \'").append (s2).append ("\'");
                    }
            }
        return sb.toString ();
        }
}
