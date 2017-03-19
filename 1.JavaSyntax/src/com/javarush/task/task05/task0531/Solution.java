package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution
{

    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int            v1     = Integer.parseInt(reader.readLine());
        int            v2     = Integer.parseInt(reader.readLine());

        int v3 = Integer.parseInt(reader.readLine());
        int v4 = Integer.parseInt(reader.readLine());
        int v5 = Integer.parseInt(reader.readLine());
        System.out.println("Minimum = " + min(v1, v2, v3, v4, v5));
        }


    public static int min(int a, int b)
        {
        return a < b ? a : b;
        }

    public static int min(int v1, int v2, int v3, int v4, int v5)
        {
        int m = min(v1, v2);
        m = min(m, v3);
        m = min(m, v4);
        m = min(m, v5);
        return m;
        }
}
