package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.*;

/**
 * Created by Administrator on 01.05.2017.
 */
public class AdvertisementManager
{
    AdvertisementStorage storage = AdvertisementStorage.getInstance ( );
    private int timeSeconds;   //время выполнения заказа поваром

    private Set<List> set = new HashSet<> ();
    public AdvertisementManager(int timeSeconds)
        {
        this.timeSeconds = timeSeconds;
        }

    /*
        public void processVideos()
            {
            List<Advertisement> list = storage.list ( );

            if (list.isEmpty ( ))
                throw new NoVideoAvailableException ( );
            // ConsoleHelper.writeMessage ("calling processVideos method");
            }
    */
    public void processVideos() throws NoVideoAvailableException
        {
        if (storage.list ( ).isEmpty ( ))
            {
        //        StatisticManager.getInstance ( ).register (new NoAvailableVideoEventDataRow (timeSeconds));
                throw new NoVideoAvailableException ( );
            }
        set.add (storage.list ( ));
        makeSet (storage.list ( ));
        List<List<Advertisement>> availableAds = getAvailableVideos (set);
        Collections.sort (availableAds, new Comparator<List<Advertisement>> ( )
        {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2)
                {
                int compareRes = (int) (getAmountOnDisplaying (o2) - getAmountOnDisplaying (o1));
                if (compareRes == 0)
                    {
                        compareRes = getTotalDuration (o2) - getTotalDuration (o1);
                    }
                if (compareRes == 0)
                    compareRes = o1.size ( ) - o2.size ( );
                return compareRes;
                }
        });
        List<Advertisement> toShow = availableAds.get (0);
        Collections.sort (toShow, new Comparator<Advertisement> ( )
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
                {
                int compareResult = (int) (o2.getAmountPerOneDisplaying ( ) - o1.getAmountPerOneDisplaying ( ));
                if (compareResult == 0)
                    compareResult = (int) (1000 * o1.getAmountPerOneDisplaying ( ) / o1.getDuration ( ) - 1000 * o2.getAmountPerOneDisplaying ( ) / o2.getDuration ( ));
                return compareResult;
                }
        });
    //    StatisticManager.getInstance ( ).register (new VideoSelectedEventDataRow (toShow, getAmountOnDisplaying (toShow), getTotalDuration (toShow)));
        for (Advertisement ad : toShow)
            {
                ConsoleHelper.writeMessage (ad.getName ( ) + " is displaying... " + ad.getAmountPerOneDisplaying ( ) + ", " + (1000 * ad.getAmountPerOneDisplaying ( ) / ad.getDuration ( )));
                ad.revalidate ( );
            }
        }

    public void makeSet(List<Advertisement> list)
        {
        if (list.isEmpty ( ))
            return;
        else
            {
                for (int i = 0; i < list.size ( ); i++)
                    {
                        List<Advertisement> newList = new ArrayList<> (list);
                        newList.remove (i);
                        if (!newList.isEmpty ( ))
                            set.add (newList);
                        makeSet (newList);
                    }
            }
        }

    public List<List<Advertisement>> getAvailableVideos(Set<List> set)
        {
        List<List<Advertisement>> result = new ArrayList<> ( );
        for (List<Advertisement> list : set)
            {
                if (getTotalDuration (list) <= timeSeconds)
                    result.add (list);
            }
        return result;
        }

    public int getTotalDuration(List<Advertisement> list)
        {
        int duration = 0;
        for (Advertisement ad : list)
            {
                duration += ad.getDuration ( );
            }
        return duration;
        }

    public long getAmountOnDisplaying(List<Advertisement> list)
        {
        long amount = 0;
        for (Advertisement ad : list)
            {
                amount += ad.getAmountPerOneDisplaying ( );
            }
        return amount;
        }
}
