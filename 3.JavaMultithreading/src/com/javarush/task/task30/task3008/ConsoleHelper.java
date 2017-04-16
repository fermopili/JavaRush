package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 13.04.2017.
 */
public class ConsoleHelper
{
    static private BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

    static public void writeMessage(String message)
        {
        System.out.println (message);
        }

    static public String readString()
        {
        String message = "";
        boolean ret=false;
        while (!ret)
            try
                {
                    message = reader.readLine ( );
                    ret=true;
                }
            catch (IOException e)
                {
                    writeMessage ("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                    message = null;
                }
        return message;
        }

    static public int readInt()
        {
        int res = 0;
        try
            {
                res = Integer.parseInt (readString ( ));
            }
        catch (NumberFormatException e)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
                res = readInt ( );
            }
        return res;
        }
}
