package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution
{

    public static void main(String[] args)
        {
        class EmulateThreadFactoryTask implements Runnable
        {
            @Override
            public void run()
                {
                emulateThreadFactory ( );
                }
        }

        ThreadGroup group  = new ThreadGroup ("firstGroup");
        Thread      thread = new Thread (group, new EmulateThreadFactoryTask ( ));

        ThreadGroup group2  = new ThreadGroup ("secondGroup");
        Thread      thread2 = new Thread (group2, new EmulateThreadFactoryTask ( ));

        thread.start ( );
        thread2.start ( );
        }

    private static void emulateThreadFactory()
        {
        AmigoThreadFactory factory = new AmigoThreadFactory ( );
        Runnable r = new Runnable ( )
        {
            @Override
            public void run()
                {
                System.out.println (Thread.currentThread ( ).getName ( ));
                }
        };
        factory.newThread (r).start ( );
        factory.newThread (r).start ( );
        factory.newThread (r).start ( );
        }

    static public class AmigoThreadFactory implements ThreadFactory
    {

        AtomicInteger factoryNum = new AtomicInteger (0);
        static AtomicInteger factoryCount = new AtomicInteger (0);
        AtomicInteger threadNum = new AtomicInteger (0);

        public AmigoThreadFactory()
            {
            factoryNum.set (factoryCount.incrementAndGet ( ));
            }

        public Thread newThread(Runnable r)
            {
            threadNum.set(threadNum.incrementAndGet ());
            Thread thread = new Thread (r);
            thread.setDaemon (false);
            thread.setPriority ((Thread.NORM_PRIORITY));
            String threadName = Thread.currentThread ( ).getThreadGroup ( ).getName ( );
            thread.setName (threadName + "-pool-" + factoryNum.get ( ) + "-thread-"+threadNum);
            return thread;
            }
    }
}
