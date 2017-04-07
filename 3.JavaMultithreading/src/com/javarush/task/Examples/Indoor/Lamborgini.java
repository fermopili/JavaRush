package com.javarush.task.Examples.Indoor;

/**
 * Created by Administrator on 03.04.2017.
 */

public class Lamborgini extends Car
{
    public class LamborginiDoor extends Car.Door
    {
        LamborginiDoor(Car car)
            {
            car.super ( );
            }
    }
}