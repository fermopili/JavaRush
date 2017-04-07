package com.javarush.task.task24.task2409;

/**
 * Created by Administrator on 03.04.2017.
 */
public class Denim extends  AbstractJeans
{
    public Denim(int id, int lenght, int size, double price)
        {
        super (id, lenght, size, price);
        }

    @Override
    public String toString()
        {
        return "Denim"+super.toString () ;
        }
}
