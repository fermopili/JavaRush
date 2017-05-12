package com.javarush.task.task32.task3203;

import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution
{
    public static void main(String[] args)
        {
        String text = getStackTrace (new IndexOutOfBoundsException ("fff"));
        System.out.println (text);
        }

    public static String getStackTrace(Throwable throwable)
        {
        StringWriter  stringWriter  = new StringWriter ( );
        PrintWriter   printWriter   = new PrintWriter (stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString ();
/*
        StackTraceElement[] stackTrace = throwable.getStackTrace ( );
        StringBuilder stringBuilder = new StringBuilder ( );
        for (int i = 0; i < stackTrace.length; i++)
            {
                stringBuilder.append (stackTrace[i].toString ( ));
                stringBuilder.append ("\n");
            }
        return stringBuilder.toString ( )   ;
        */

        }
}