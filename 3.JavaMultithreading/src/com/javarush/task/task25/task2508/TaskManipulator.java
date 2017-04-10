package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    Thread tread;
    @Override
    public void run()
        {
        try
            {
                while (! Thread.currentThread().isInterrupted ( ))
                    {  System.out.println ( Thread.currentThread().getName ( ));
                        Thread.sleep (100);
                    }
            }
        catch (InterruptedException e)
            {
               // e.printStackTrace ( );
            }
        }
    @Override
    public void start(String threadName)
        {
        tread = new Thread (this);
        tread.setName (threadName);
        tread.start ( );
        }

    @Override
    public void stop()
        {
        tread.interrupt ( );
        }
}
