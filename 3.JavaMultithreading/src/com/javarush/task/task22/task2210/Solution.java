package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution
{
    public static void main(String[] args)
        {

        }

    public static String[] getTokens(String query, String delimiter)
        {
        ArrayList<String> list=new ArrayList<> ();
        StringTokenizer tokenizer =   new StringTokenizer (query, delimiter);
        while (tokenizer.hasMoreTokens ( ))
            {
                String token = tokenizer.nextToken ( );
                list.add (token);
                System.out.println ("{"+token+"}");
            };
        String[] arr = new String[list.size()];
        return  (String[]) list.toArray (arr);
        }
}
