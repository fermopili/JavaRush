package com.javarush.task.task21.task2113;

/**
 * Created by Administrator on 30.03.2017.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
        {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        }

    @Override
    public String toString()
        {
        return "Horse{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", distance=" + distance +
                '}';
        }

    public String getName()
        {
        return name;
        }

    public void setName(String name)
        {
        this.name = name;
        }

    public void setSpeed(double speed)
        {
        this.speed = speed;
        }

    public void setDistance(double distance)
        {
        this.distance = distance;
        }

    public double getSpeed()
        {

        return speed;
        }

    public double getDistance()
        {
        return distance;
        }

    public void move()
        {
        double d = getDistance ( );
        d = d + getSpeed() * Math.random ( );
        setDistance (d);
        }

    public void print()
        {
            int d= (int)getDistance ( );
        for(int i=0;i<d;i++)
            System.out.print (".");
        System.out.println (name);
        }

}
