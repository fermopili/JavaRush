package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] m = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 15; i++) {
            m[i] = Integer.parseInt(reader.readLine());
        }
        int sumEven=0;
        int sumOdd=0;
        for (int i = 0; i < 15; i++) {
        if(((i/2)*2)==i)
            sumEven+=m[i];
        else
            sumOdd+=m[i];
        }
       if(sumEven>sumOdd)
           System.out.println("В домах с четными номерами проживает больше жителей.");
        else
           System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
