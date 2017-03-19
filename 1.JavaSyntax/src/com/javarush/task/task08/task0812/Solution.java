package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a=new ArrayList<Integer>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++)
            a.add(Integer.parseInt(reader.readLine())) ;
         int count=1;
         int max=1;
         int value =a.get(0);
         for(int i=1;i<a.size();i++)
         {
             if(value==a.get(i))
             {
                 count++ ;
                 if(count>max)
                     max=count;
             }
             else
             {value=a.get(i);
                 count=1;
             }

         }
         System.out.println(max);
    }
}