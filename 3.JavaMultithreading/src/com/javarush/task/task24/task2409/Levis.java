package com.javarush.task.task24.task2409;

/**
 * Created by Administrator on 03.04.2017.
 */
public class Levis extends AbstractJeans
{

    public Levis(int id, int lenght, int size, double price)
        {
        super (id, lenght, size, price);
        }

    @Override
    public String toString()
        {
        return "Levis"+super.toString ();
        }
}
