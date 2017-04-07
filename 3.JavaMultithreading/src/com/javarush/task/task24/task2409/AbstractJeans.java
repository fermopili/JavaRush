package com.javarush.task.task24.task2409;

/**
 * Created by Administrator on 03.04.2017.
 */
public abstract class AbstractJeans implements Jeans
{
    private int    id;
    private int    lenght;
    private int    size;
    private double price;

    @Override
    public int getId()
        {
        return id;
        }

    @Override
    public double getPrice()
        {
        return price;
        }

    @Override
    public String getTM()
        {
        return null;
        }

    @Override
    public int getLength()
        {
        return lenght;
        }

    @Override
    public int getSize()
        {
        return size;
        }

    @Override
    public String toString()
        {
        return "AbstractJeans{" +
                "id=" + id +
                ", lenght=" + lenght +
                ", size=" + size +
                ", price=" + price +
                '}';
        }

    public AbstractJeans(int id, int lenght, int size, double price)
        {
        this.id = id;
        this.lenght = lenght;
        this.size = size;
        this.price = price;
        }


}
