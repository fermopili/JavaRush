package com.javarush.task.Examples.BlockingQueueExamples;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 13.04.2017.
 */
public class Producer implements Runnable
{
    private BlockingQueue bq = null;

    public Producer(BlockingQueue queue)
        {
        this.setBlockingQueue (queue);
        }

    public void run()
        {

        Random rand = new Random ( );
        int    res  = 0;
        try
            {
                while (true)
                    {
                        res = Addition (rand.nextInt (100), rand.nextInt (50));
                        System.out.println ("Produced: " + res);
                        bq.put (res);
                        Thread.sleep (10);
                    }
      /*  res = Addition(rand.nextInt(100), rand.nextInt(50));
        System.out.println("Produced: " + res);
        bq.put(res);
        Thread.sleep(1000);
        res = Addition(rand.nextInt(100), rand.nextInt(50));
        System.out.println("Produced: " + res);
        bq.put(res);
        */
            }
        catch (InterruptedException e)
            {
                e.printStackTrace ( );
            }
        }

    public void setBlockingQueue(BlockingQueue bq)
        {
        this.bq = bq;
        }

    public int Addition(int x, int y)
        {
        int result = 0;
        result = x + y;
        return result;
        }

}
