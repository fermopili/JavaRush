package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution
{

    public static void main(String[] args)
        {
        MyThread myThread = new Solution ( ).new MyThread ("super secret key");
        myThread.start ( );

        new Solution ( ).new MyThread ("super secret key2").start ( );;
        }

    public class MyThread extends Thread
    {
        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
        {
            public MyUncaughtExceptionHandler()
                {
                    r=50;
                }

            @Override
            public void uncaughtException(Thread t, Throwable e)
                {
                try
                    {
                        Thread.sleep (500);
                    }
                catch (InterruptedException e1)
                    {
                        e1.printStackTrace ( );
                    }
                String str = String.format ("%s, %s, %s", secretKey, t.getName ( ), e.getMessage ( ));
                System.out.println (str);
                }
        }

        private String secretKey;

        public MyThread(String secretKey)
            {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler (new MyUncaughtExceptionHandler ( ));
            //  setDaemon (true);
            }

     private   int r=0;
        @Override
        public void run()
            {
                while(r<100)
                    {r++; System.out.println (r);
                    }
            throw new NullPointerException ("it's an example");
            }

    }

}

