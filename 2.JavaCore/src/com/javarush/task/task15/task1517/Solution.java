package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import java.io.IOException;

public class Solution
{
    public static int A = 0;

    static
        { A/=0;
          // throw new Exception(); //throw an exception here - выбросьте эксепшн тут
        }

    public static int B = 5;

    public static void main(String[] args)
        {
        System.out.println(B);
        }
}
