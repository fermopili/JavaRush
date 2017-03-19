package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v1 = Integer.parseInt(reader.readLine());
        if (v1 <= 0) throw new NumberFormatException();
        int v2 = Integer.parseInt(reader.readLine());
        if (v2 <= 0) throw new NumberFormatException();
        while (v2 != 0)
            {
                int tmp = v1 % v2;
                v1 = v2;
                v2 = tmp;
            }
        System.out.println(v1);
        }
}
