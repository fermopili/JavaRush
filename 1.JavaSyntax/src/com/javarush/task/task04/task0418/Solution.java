package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());
        int t2 = Integer.parseInt(reader.readLine());
        if(t1<t2)
            System.out.println(t1);
        else
            System.out.println(t2);
    }
}