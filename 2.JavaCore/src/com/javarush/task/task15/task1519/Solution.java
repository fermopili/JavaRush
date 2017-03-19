package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
            {
                String key = reader.readLine();
                if ("exit".equals(key))
                    break;
                if (key.contains("."))
                    {
                        try
                            {
                                Double d = Double.valueOf(key);
                                print(d);
                            }
                        catch (NumberFormatException e)
                            {
                                print(key);
                            }
                        continue;
                    }
                try
                    {
                        int i = Integer.valueOf(key);
                        if ((i<=0)||(i >=128))
                            {
                                print(i);
                                continue;
                            }
                        short s = Short.valueOf(key);
                        if ((s > 0) && (s < 128))
                                   print(s);

                    }
                catch (NumberFormatException e)
                    {
                        print(key);
                    }
            }
        reader.close();
        }

    public static void print(Double value)
        {
        System.out.println("Это тип Double, значение " + value);
        }

    public static void print(String value)
        {
        System.out.println("Это тип String, значение " + value);
        }

    public static void print(short value)
        {
        System.out.println("Это тип short, значение " + value);
        }

    public static void print(Integer value)
        {
        System.out.println("Это тип Integer, значение " + value);
        }
}
