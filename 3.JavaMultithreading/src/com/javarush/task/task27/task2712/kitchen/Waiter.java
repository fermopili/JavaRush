package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 28.04.2017.
 */
public class Waiter implements Observer
{
    @Override
    public void update(Observable cook, Object order)
        {
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
        }
}
