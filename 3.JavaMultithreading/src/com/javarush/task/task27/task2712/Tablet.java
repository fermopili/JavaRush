package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 27.04.2017.
 */
public class Tablet extends Observable
{

    private   Order      order;
    protected List<Dish> dishes;
    final     int        number;
    private static final Logger logger = Logger.getLogger (Tablet.class.getName ( ));

    public Tablet(int b)
        {
        this.number = b;
        }

    @Override
    public String toString()
        {
        return "Tablet{" + "number=" + number + '}';
        }

    public Order createOrder()
        { // было void ??

        try
            { Order order;
                order = new Order (this);
                if (!order.isEmpty ( ))
                    {
                        ConsoleHelper.writeMessage (order.toString ( ));
                        setChanged ( );
                        notifyObservers (order);
                        try
                            {
                                new AdvertisementManager (order.getTotalCookingTime ( ) * 60).processVideos ( );
                            }
                        catch (NoVideoAvailableException e)
                            {
                                logger.log (Level.INFO, "No video is available for the order " + order);
                            }
                    }
            }
        catch (IOException e)
            {   logger.log (Level.SEVERE, "Console is unavailable.");
                return null;
            }
        return order;
        }
}
