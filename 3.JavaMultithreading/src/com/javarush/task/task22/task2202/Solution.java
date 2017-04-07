package com.javarush.task.task22.task2202;

import java.io.IOException;

/*
Найти подстроку
*/
public class Solution
{
    public static void main(String[] args)
        {
        System.out.println (getPartOfString ("JavaRush - лучший сервис обучения Java."));
        }

    public static String getPartOfString(String string) throws TooShortStringException
        {
        if (string == null)
            throw new TooShortStringException ( );
        String[] strA=string.split (" ");
        if(strA.length<5)
            throw new TooShortStringException ( );

        return strA[1]+" "+strA[2]+" "+strA[3]+" "+strA[4];
        }

    public static class TooShortStringException extends RuntimeException
    {
    }
}
