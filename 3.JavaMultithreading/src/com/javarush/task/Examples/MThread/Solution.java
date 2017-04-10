package com.javarush.task.Examples.MThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 07.04.2017.
 */
public class Solution
{
    static int END = 5;
    static class FF implements Runnable
    {Thread current;
        int r = 0;
        @Override
        public void run()
            {  current = Thread.currentThread ( );
           /*  while (true)
                {  try {   Thread.sleep (1000);   }
                    catch (InterruptedException e)
                        {   e.printStackTrace ( );  }
                    System.out.println (current.getName ()+"   r=" + r);r++;
                    if (END == 15)
                        { System.out.println (current.getName ()+" CLOSE");
                           break;
                        }
                }*/
            while (!current.isInterrupted ())
                {                    try
                        {
                            Thread.sleep (1000);
                        }
                    catch (InterruptedException e)
                        {
                           // e.printStackTrace ( );
                            System.out.println (current.getName ()+" INTERRUPT");
                            break;
                        }
                    System.out.println (current.getName ()+"   r=" + r);r++;
                    if (END == 15)
                        { System.out.println (current.getName ()+" CLOSE");
                            break;
                        }
                }
            }
    }
    public static void main(String[] args) throws InterruptedException, IOException
        {
        FF ff= new FF ();
        Thread ffThread= new Thread (ff, "ffThread");
        ffThread.start ();
        Clock  clock       = new Clock ( );
        Thread clockThread = new Thread (clock, "MY BAD CLOCK");
        clockThread.start ( );
        System.out.println ("clockThread     " + clockThread.isInterrupted ( ));
        Thread.sleep (1000);
        clockThread.interrupt ( );
        clock.getInt ( );
        System.out.println ("clockThread     " + clockThread.isInterrupted ( ));
        while(true)
            {
                BufferedReader reader=new BufferedReader (new InputStreamReader (System.in));
                END=Integer.parseInt (reader.readLine ());
                System.out.println ("input END = "+END);
               // if(END==5)
              //      ffThread.interrupt ();
                if(END==8)
                    break;
            }

        System.out.println ("END >>>>>>>>>>>>");
        }
}
