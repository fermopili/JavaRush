package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
       if(i==0)
           System.out.println("ноль");
       else {
           if (i > 0)
               System.out.print("положительное ");
           if (i < 0)
               System.out.print("отрицательное ");
           if ((i / 2) * 2 == i)
               System.out.print("нечетное число");
           else
               System.out.println("нечетное число");
       }
    }
}
