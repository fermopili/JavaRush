package com.javarush.task.Examples;

import java.util.ArrayList;

/**
 * Created by Administrator on 03.04.2017.
 */

class Car
{
    public ArrayList ArrayListcreatePoliceCars(int count)
        {
        ArrayList result = new ArrayList ( );
          int r=0;
        for (int i = 0; i < count; i++)
            {
                final int number = i;
                result.add (new Car ( )
                {
                    int policeNumber = number;

                });
            }
        return result;
        }
}