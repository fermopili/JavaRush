package com.javarush.task.task26.task2613;


import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Administrator on 25.05.2017.
 */
public class CashMachine
{
    public static void main(String[] args)
        {
        Operation operation;
        do
            {
                try
                    {
                        operation = ConsoleHelper.askOperation ( );
                        CommandExecutor.execute (operation );
                    }
                catch (InterruptOperationException e)
                    {
                        ConsoleHelper.writeMessage ( "QYY");
                       return;
                    }


            } while (operation != Operation.EXIT);
        }
}
