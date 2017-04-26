package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution
{
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2)
        {
        System.out.println (obj1 + " after " + obj2);
        synchronized (obj1)
            {
                synchronized (obj2)
                    {
                        System.out.println (obj1 + " " + obj2);
                    }
            }
        }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception
        {
        //do something here
        Thread t1 = new Thread ( )
        {

            @Override
            public void run()
                {
                synchronized (o1)
                    {
                        synchronized (o2)
                            {
                                try
                                    {
                                        sleep (1000);
                                    }
                                catch (InterruptedException e)
                                    {
                                        e.printStackTrace ( );
                                    }
                            }
                    }
                }
        };
        Thread t2 = new Thread ( )
        {

            @Override
            public void run()
                {
                solution.someMethodWithSynchronizedBlocks (o1, o2);
                }
        };
        System.out.println ("+++"+t1.getState ( ));
        t1.start ( );
        solution.someMethodWithSynchronizedBlocks (o1, o2);
        //  Thread.sleep (10);
        // t2.start ( );
        // Thread.sleep (10);
        System.out.println ("---"+t1.getState ( ));
          synchronized (o1)
        {
           System.out.println ("==="+t1.getState ( ));
            if (Thread.State.TIMED_WAITING.equals (t1.getState ( ))) return true;
            return false;
        }

        }

    public static void main(String[] args) throws Exception
        {
        final Solution solution = new Solution ( );
        final Object   o1       = new Object ( );
        final Object   o2       = new Object ( );
        System.out.println (isNormalLockOrder (solution, o1, o2));
     //   System.out.println (isNormalLockOrder (solution, o2, o1));

        }
}
