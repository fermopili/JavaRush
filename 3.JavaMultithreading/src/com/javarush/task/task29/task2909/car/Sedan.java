package com.javarush.task.task29.task2909.car;

/**
 * Created by Administrator on 10.04.2017.
 */
public class Sedan extends Car
{
    public Sedan( int numberOfPassengers)
        {
        super (SEDAN, numberOfPassengers);
        }
    @Override
    public int getMaxSpeed()
        {
        return MAX_SEDAN_SPEED;
        }
}
