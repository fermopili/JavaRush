package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 27.04.2017.
 */
public class Order
{
    private final Tablet     tablet;

    public List<Dish> getDishes()
        {
        return dishes;
        }

    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
        {

        dishes = ConsoleHelper.getAllDishesForOrder ( );
        this.tablet = tablet;
        }

    public boolean isEmpty()
        {
        return dishes.isEmpty ( );
        }

    @Override
    public String toString()
        {
        return isEmpty ( ) ? "" : "Your order: " + dishes + " of " + tablet;
        }

    public int getTotalCookingTime()
        {
        int time = 0;
        for (Dish dish : dishes)
            {
                time += dish.getDuration ( );
            }
        return time; //minutes
        }
}
