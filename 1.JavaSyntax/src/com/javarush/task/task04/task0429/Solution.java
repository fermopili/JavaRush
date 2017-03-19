package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int p = 0;
        int m=0;
        for (int i = 0; i < 3; i++) {
            int v=Integer.parseInt(reader.readLine());
            if ( v > 0)
                p++;
            if (v < 0)
                m++;
        }
        System.out.println("количество отрицательных чисел: "+m);
        System.out.println("количество положительных чисел: "+p);
    }
}
