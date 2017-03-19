package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution
{
    public static void main(String[] args)
        {

        }

    static
        {
            //add your code here - добавьте код тут
            try
                {
                    reset();
                }
            catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

    public static Flyable result;

    public static void reset() throws IOException
        {
        //add your code here - добавьте код тут
        String         str    = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
            {
                str = reader.readLine();
            }
        catch (IOException e)
            {
                e.printStackTrace();
            }

        if ("helicopter".contains(str))
            {
                result = new Helicopter();
            }
        if ("plane".contains(str))
            {
                int n = Integer.parseInt(reader.readLine());
                result = new Plane(n);
            }
        reader.close();
        }
}
