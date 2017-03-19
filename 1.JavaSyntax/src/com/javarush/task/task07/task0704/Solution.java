package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m=new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++)
            m[i]=Integer.parseInt(reader.readLine());
        int a;
        for (int i=0;i<5;i++) {
            a = m[i];
            m[i]=m[9-i];
            m[9-i]=a;
        }
        for (int i=0;i<10;i++)
            System.out.println(m[i]);
    }
}

