package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());
        int t2 = Integer.parseInt(reader.readLine());
        int t3 = Integer.parseInt(reader.readLine());
        int t4 = Integer.parseInt(reader.readLine());
        if (t1 == t2 && t2 == t3 && t3 == t4)
            System.out.println(t1);
        else {
            int max = t1;
            if (t2 > max)
                max = t2;
            if (t3 > max)
                max = t3;
            if (t4 > max)
                max = t4;
            System.out.println(max);
        }
    }
}
