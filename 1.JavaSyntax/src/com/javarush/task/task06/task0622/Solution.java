package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Числа по возрастанию
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        int[]          ar     = new int[5];
        for (int i = 0; i < 5; i++)
            ar[i] = Integer.parseInt (reader.readLine ( ));
        //напишите тут ваш код
        ArrayList values = new ArrayList ( );
        for (int i = 0; i < 5; i++)
            values.add (ar[i]);
        Collections.sort (values);
        for (int i = 0; i < 5; i += 1)
            System.out.println (values.get (i));
        }
}
