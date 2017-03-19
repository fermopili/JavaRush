package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        double sum=0;
        int k=0;
       while(t!=-1)
       {t = Integer.parseInt(reader.readLine());

           if(t==-1)
           sum/=k;
       else
           { sum+=t; k++;}
       }
        System.out.println(sum);
    }
}

