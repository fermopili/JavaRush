package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 02.05.2017.
 */
public class CookedOrderEventDataRow implements EventDataRow
{
    private final String     tabletName;
    private final String     cookName;
    private final int        cookingTimeSeconds;
    private final List<Dish> cookingDishs;
    private         Date       currentDate;
    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs)
        {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        currentDate=new Date ();
        }

    @Override
    public EventType getType()
        {
        return EventType.COOKED_ORDER;
        }
}
