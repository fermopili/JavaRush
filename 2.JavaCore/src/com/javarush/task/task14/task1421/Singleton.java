package com.javarush.task.task14.task1421;

/**
 * Created by Administrator on 16.03.2017.
 */
public class Singleton
{
    private static Singleton  instance=null;

    public static Singleton getInstance()
        {if(instance==null)
            instance=new Singleton();
        return instance;
        }

    private Singleton()
        {
        }
}
