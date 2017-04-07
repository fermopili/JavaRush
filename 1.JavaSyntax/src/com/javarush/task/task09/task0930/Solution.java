package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Задача по алгоритмам
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader    reader = new BufferedReader (new InputStreamReader (System.in));
        ArrayList<String> list   = new ArrayList<String> ( );
        while (true)
            {
                String s = reader.readLine ( );
                if (s.isEmpty ( )) break;
                list.add (s);
            }
        String[] array = list.toArray (new String[list.size ( )]);
        sort (array);
        for (String x : array)
            {
                System.out.println (x);
            }
        }

    public static void sort(String[] array)
        {
        //напишите тут ваш код
        int      countS = 0;
        int      countD = 0;
        String[] tmp    = new String[array.length];
        for (String x : array)// Calculating the number of rows and digits
            {
                if (isNumber (x))
                    countD++;
                else
                    countS++;
            }
        String[] arrayS = new String[countS];
        String[] arrayD = new String[countD];
        int      indexD = 0;
        int      indexS = 0;
        for (String x : array)// Array decomposition
            {
                if (isNumber (x))
                    arrayD[indexD++] = x;
                else
                    arrayS[indexS++] = x;
            }
        for (int i = 0; i < arrayD.length; i++)//sorting
            {
                for (int j = i + 1; j < arrayD.length; j++)
                    {
                        if (Integer.parseInt (arrayD[i]) < Integer.parseInt (arrayD[j]))
                            {
                                String str = arrayD[j];
                                arrayD[j] = arrayD[i];
                                arrayD[i] = str;
                            }
                    }
            }
        for (int i = 0; i < arrayS.length; i++)//sorting
            {
                for (int j = i + 1; j < arrayS.length; j++)
                    {
                        if (isGreaterThan (arrayS[i], arrayS[j]))
                            {
                                String str = arrayS[j];
                                arrayS[j] = arrayS[i];
                                arrayS[i] = str;
                            }
                    }
            }
        indexS = 0;
        indexD = 0;
        for (int i = 0; i < array.length; i++)// Array composition
            {
                if (isNumber (array[i]))
                    tmp[i] = arrayD[indexD++];
                else
                    tmp[i] = arrayS[indexS++];
            }
        for (int i = 0; i < tmp.length; i++)// result
            array[i] = tmp[i];
        }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
        {
        return a.compareTo (b) > 0;
        }

    // Переданная строка - это число?
    public static boolean isNumber(String s)
        {
        if (s.length ( ) == 0) return false;

        char[] chars = s.toCharArray ( );
        for (int i = 0; i < chars.length; i++)
            {
                char c = chars[i];
                if ((i != 0 && c == '-') // есть '-' внутри строки
                        || (!Character.isDigit (c) && c != '-')) // не цифра и не начинается с '-'
                    {
                        return false;
                    }
            }
        return true;
        }
}
