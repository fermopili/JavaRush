package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by Administrator on 28.04.2017.
 */
public enum Dish
{
    Fish (25),//("Fish"),
    Steak (30),//("Steak"),
    Soup (15),//("Soup"),
    Juice (5),//("Juice"),
    Water (3);//  ("Water");
    private int duration;
    public int getDuration()
        {
        return duration;
        }

    Dish(int duration)
        {
        this.duration = duration;
        }

    public static String allDishesToString()
        {
        String allDishes = "";
        for (Dish dish : Dish.values ( ))
            {
                if (allDishes.isEmpty ( )) allDishes += dish;
                else allDishes += ", " + dish;
            }
        return allDishes.trim ( );
        }
}
