package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by Administrator on 30.04.2017.
 */
public class Consumer implements Runnable
{


    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
        {
        this.queue = queue;
        }

    @Override
    public void run()
        {

                try
                    { Thread.sleep (450);
                        while(!Thread.currentThread ().isInterrupted ())
                        {
                            ShareItem item = queue.take ( );
                            System.out.format ("Processing %s\n",item.toString());

                        }
                    }
                catch (InterruptedException e)
                    {
                    }

        }
}
