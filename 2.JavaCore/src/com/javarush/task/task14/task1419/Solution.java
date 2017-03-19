package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
        {
        initExceptions();

        for (Exception exception : exceptions)
            {
                System.out.println(exception);
            }
        }
    private static void initExceptions()
        {   //it's first exception
        try
            {
                float i = 1 / 0;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                int[] i = new int[3];
                i[14] = 9;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
               String str=null;
                str.length();
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                float i = 1 / 0;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                int[] i = new int[3];
                i[41] = 9;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                String str=null;
                str.length();
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                String str=null;
                str.length();
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        //напишите тут ваш код
        try
            {
                float i = 1 / 0;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                int[] i = new int[3];
                i[45] = 9;
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }
        try
            {
                String str=null;
                str.length();
            }
        catch (Exception e)
            {
                exceptions.add(e);
            }

        }

}
