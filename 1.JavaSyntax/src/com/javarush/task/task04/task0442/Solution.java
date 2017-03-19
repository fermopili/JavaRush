package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int t1 = 0;
        while(t1!=-1)
        { t1 = Integer.parseInt(reader.readLine());
        sum+=t1;
        }
        System.out.println(sum);
    }
}
