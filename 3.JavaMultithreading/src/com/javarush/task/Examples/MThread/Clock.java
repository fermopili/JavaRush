package com.javarush.task.Examples.MThread;

/**
 * Created by Administrator on 07.04.2017.
 */
public class Clock implements Runnable
{
    int c = 0;
    Thread current;

    public void run()
        {
        current = Thread.currentThread ( );

        while (!current.isInterrupted ( ))
            {
                try
                    {
                        Thread.sleep (100);
                    }
                catch (InterruptedException e)
                    {
                        e.printStackTrace ( );
                        System.out.println ("INERRUPT " + current.isInterrupted ( ));
                        break;
                    }
                System.out.println (current.getName ( )+"  Tik" + (c++) + "  " + current.isInterrupted ( ) );
            }

        System.out.println (current.getName ( )+"  Tik" + (c++) + "  " + current.isInterrupted ( ) );
        }

    public void getInt()
        {
        System.out.println (current.getName ( ) +"  Tik" + (c++) + "  " + current.isInterrupted ( ) );

        }
}