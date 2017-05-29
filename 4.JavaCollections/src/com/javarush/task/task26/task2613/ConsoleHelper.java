package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 25.05.2017.
 */
public class ConsoleHelper
{
    static private BufferedReader bis = new BufferedReader ( new InputStreamReader ( System.in ) );

    public static void writeMessage(String message)
        {
        System.out.println ( message );
        }

    public static String readString()  throws InterruptOperationException
        {
        String input = "";
        try
            {
                input = bis.readLine ( );
                if (input.equalsIgnoreCase ( "exit" ))
                    {
                        throw new InterruptOperationException ( );
                    }
            }
        catch (IOException ignored)
            {
            }
        return input;
        }

    public static String askCurrencyCode()  throws InterruptOperationException
        {
        String str = readString ( );
        if (str.length ( ) != 3)
            {
                writeMessage ( "Error input data" );
                return askCurrencyCode ( );
            }
        return str.toUpperCase ( );
        }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
        {
        writeMessage ( "Input nominal and total:" );

        String[] input;
        while (true)
            {
                input = readString ( ).split ( " " );

                int nominal = 0;
                int total   = 0;
                try
                    {
                        nominal = Integer.parseInt ( input[0] );
                        total = Integer.parseInt ( input[1] );
                    }
                catch (Exception e)
                    {
                        writeMessage ( "Error, Repeat again:" );
                        continue;
                    }
                if (nominal <= 0 || total <= 0)
                    {
                        writeMessage ( "Error, Repeat again:" );
                        continue;
                    }
                break;
            }
        return input;
        }

    public static Operation askOperation() throws InterruptOperationException
        {
        do
            {
                writeMessage ( "Choice operation:\n1) INFO\n2) DEPOSIT\n3) WITHDRAW\n4) EXIT" );
                try
                    {
                        String input = readString ( );
                        return Operation.getAllowableOperationByOrdinal ( Integer.parseInt ( input ) );
                    }
                catch (IllegalArgumentException e)
                    {
                        writeMessage ( "You input wrong! Try Again." );
                        continue;
                    }
            } while (true);
        }


}
