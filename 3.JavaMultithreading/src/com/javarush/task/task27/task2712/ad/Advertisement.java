package com.javarush.task.task27.task2712.ad;

/**
 * Created by Administrator on 01.05.2017.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long   initialAmount;  //начальная сумма, стоимость рекламы в копейках
    private int    hits;   //количество оплаченных показов
    private int    duration; // продолжительность в секундах
    private long   amountPerOneDisplaying; //стоимость одного показа в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
        {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
        }

    public String getName()
        {
        return name;
        }

    public int getDuration()
        {
        return duration;
        }

    public long getAmountPerOneDisplaying()
        {
        return amountPerOneDisplaying;
        }

    public void revalidate()
        {
        if (hits <= 0)
            {
                throw new UnsupportedOperationException ( );
            }
        hits--;
        }
}
