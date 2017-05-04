package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 02.05.2017.
 */
public class StatisticManager
{
    private        StatisticStorage statisticStorage = new StatisticStorage ( );
    private static StatisticManager ourInstance      = new StatisticManager ( );

    public static StatisticManager getInstance()
        {
        return ourInstance;
        }

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<> ( );

        public StatisticStorage()
            {
            for (EventType eventType : EventType.values ( ))
                {
                    storage.put (eventType, new ArrayList<EventDataRow> ( ));
                }
            }
        private void put(EventDataRow data)
            {
            storage.get (data.getType ( )).add (data);
            }
    }

    private StatisticManager()
        {
        }

    public void register(EventDataRow data)
        {
        if (data == null)
            return;
        statisticStorage.put (data);
        }
}
