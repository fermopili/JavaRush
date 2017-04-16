package com.javarush.task.task26.task2610;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 13.04.2017.
 */
public class Consumer implements Runnable
{
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue queue)
        {
        this.queue = queue;
        }

    @Override
    public void run()
        {
        try
            {
                int i = 0;
                while (true)
                    {
                        System.out.println( queue.take());
                    }
            }
        catch (InterruptedException e)
            {
            }
        }
}
