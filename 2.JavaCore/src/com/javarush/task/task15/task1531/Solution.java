package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input=0;
        //    int input = Integer.parseInt(reader.readLine());
        reader.close();
//for(int i=0;i<10;i++)
     //   System.out.println((input+0)+"! =    "+factorialBigDecimal(new BigDecimal(3)));
        System.out.println((input+0)+"! =    "+factorialBigDecimal2(3));
        }

    public static String factorial(int n)
        {
        //add your code here
        BigDecimal f = new BigDecimal(1);
        if (n < 0)
            return "0";
        for (long i = 1; i <= n; i++)
            f = f.multiply(BigDecimal.valueOf(i));

        return f.toString();
        }

    public static BigDecimal factorialBigDecimal(BigDecimal n)
        {
        if (n.equals("0"))
            return new BigDecimal(1);
        if (n.equals("1"))
            return new BigDecimal(1);

        BigDecimal n_1=n.subtract( new BigDecimal(1));

        return   n.multiply(factorialBigDecimal(n_1));

        }
    public static int factorialBigDecimal2(int n)
        {
        if (n==0) return 1;
        if (n==1) return 1;

        return   n*factorialBigDecimal2(n-1);

        }

}
