package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by Administrator on 27.04.2017.
 */
public class Restaurant
{

    static public void main(String[] args)
        {
        // new ConsoleHelper().getAllDishesForOrder();
        Tablet tablet = new Tablet (5);
        Cook   cook   = new Cook ("VASA");
        Waiter waiter = new Waiter ( );
        cook.addObserver (waiter);
        tablet.addObserver (cook);
        tablet.createOrder ( );

        }
}
