package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m=new int[20];
        int[] i1=new int[10];
        int[] i2=new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<20;i++)
            m[i]=Integer.parseInt(reader.readLine());
        for (int i=0;i<10;i++)
            i1[i]=m[i];
        for (int i=0;i<10;i++)
            i2[i]=m[10+i];
        for (int i=0;i<10;i++)
           System.out.println(i2[i]);
    }
}
