package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 28.04.2017.
 */
public class ConsoleHelper
{
    static private BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

    static public void writeMessage(String message)
        {
        System.out.println (message);
        }
    public static String readString() throws IOException {
    return reader.readLine();
    }
    static public String readString1()
        {
        String  message = "";
        boolean ret     = false;
        while (!ret)
            try
                {
                    message = reader.readLine ( );
                    ret = true;
                }
            catch (IOException e)
                {
                    writeMessage ("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                    message = null;
                }
        return message;
        }

    static  public List<Dish> getAllDishesForOrder()throws IOException
        {
        List<Dish> dishes = new ArrayList<> ( );
        writeMessage (Dish.allDishesToString ( ));
        while (true)
            {
                boolean found = false;
                String  order = readString ( );
                if (order.equalsIgnoreCase ("exit"))
                    break;
                for (Dish dish : Dish.values ( ))
                    {
                        if (order.equals (dish.toString ( )))
                            {
                                dishes.add (dish);
                                found = true;
                            }
                    }
                if (!found)
                    {
                        writeMessage (order + " is not detected");
                    }
            }
        return dishes;
        }
}
