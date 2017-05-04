package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 28.04.2017.
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook(String name)
        {
        this.name = name;
        }

    @Override
    public String toString()
        {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
        }

    @Override
    public void update(Observable obj, Object arg)
        {
        Order  order  = (Order) arg;
        Tablet tablet = (Tablet) obj;
        ConsoleHelper.writeMessage ("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime ( ) + "min");
    //    StatisticManager.getInstance().register(new CookedOrderEventDataRow ( tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes()  ));
        setChanged ( );
        notifyObservers (order);
        }
}
