package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

/**
 * Created by Administrator on 23.05.2017.
 */
public class Aggregator
{
    static public void main(String... args)
        {
        try
            {   Provider   provider   = new Provider ( new HHStrategy () );
                Provider[] providers  = {provider};
                Controller controller = new Controller ( provider );
                controller.scan ( );
            }
        catch (NullPointerException e)
            {
            }
        }
}
