package com.javarush.task.Examples.BlockingQueueExamples;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 13.04.2017.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue)
        {
        this.queue = queue;
        }

    public void run()
        {
        try
            {
                while (true)
                    {for(int i=0;i< queue.size ();i++)
                        {  System.out.println ("Consumed: " + queue.take ( ));}

                        Thread.sleep (50);
                    }
                //     System.out.println("Consumed: " + queue.take());
                // System.out.println("Consumed: " + queue.take());
            }
        catch (InterruptedException e)
            {
                e.printStackTrace ( );
            }
        }
}
