package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution
{
    public static void main(String[] args)
        {
        try
            {   BigDecimal bigDecimal;
                boolean    flag = false;
                for (int i = 2; i < 37; i++)
                    {
                        try
                            {
                                bigDecimal = new BigDecimal (new BigInteger (args[0], i));
                                flag = true;
                                if (flag)
                                    {
                                        System.out.println (i);
                                        break;
                                    }
                            }
                        catch (Exception e)
                            {
                            }
                    }
                if (!flag)
                    {
                        throw new IllegalArgumentException ( );
                    }
            }
        catch (Exception e)
            {
                System.out.println ("incorrect");
            }
        }
}