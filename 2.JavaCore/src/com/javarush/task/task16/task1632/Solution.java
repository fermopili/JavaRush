package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static List<Thread> threads = new ArrayList<> (5);

    static
        {
            threads.add (new T1 ( ));
            threads.add (new T2 ( ));
            threads.add (new T3 ( ));
            threads.add (new T4 ( ));
            threads.add (new T5 ( ));
        }

    public static class T1 extends Thread
    {
        @Override
        public void run()
            {
            while (true) ;
            }
    }

    public static class T2 extends Thread
    {
        @Override
        public void run()
            {
            try
                {
                    Thread.sleep (500);
                }
            catch (InterruptedException e)
                {
                    System.out.println ("InterruptedException");
                }
            }
    }

    public static class T3 extends Thread
    {
        @Override
        public void run()
            {
            while (true)
                {
                    try
                        {
                            System.out.println ("Ура");
                            Thread.sleep (500);

                        }
                    catch (InterruptedException e)
                        {
                            e.printStackTrace ( );
                        }
                }
            }
    }

    public static class T4 extends Thread implements Message
    {
        @Override
        public void run()
            {
            super.run ( );
            }

        @Override
        public void showWarning()
            {
            this.interrupt ( );
            }
    }

    /*
        public static class T5 extends Thread
        {
            @Override
            public void run()
                {
                BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
                int            sum    = 0;
                int            val    = 0;
                String         str    = null;
                while (true)
                    {
                        try
                            {
                                str = reader.readLine ( );
                            }
                        catch (IOException e)
                            {
                                e.printStackTrace ( );
                            }
                        if ("N".contains (str))
                            {
                                System.out.println ("sum=" + sum);
                                break;
                            }
                        sum += Integer.parseInt (str);
                    }
                try
                    {
                        reader.close ( );
                    }
                catch (IOException e)
                    {
                        e.printStackTrace ( );
                    }
                }
        }
        */
    public static class T5 extends Thread
    {
        @Override
        public void run()
            {
            ArrayList<Integer> list   = new ArrayList<> ( );
            BufferedReader     reader = new BufferedReader (new InputStreamReader (System.in));
            while (!isInterrupted ( ))
                {
                    try
                        {
                            String read = reader.readLine ( );
                            if (read.equals ("N"))
                                {
                                    int sum = 0;
                                    for (int i : list)
                                        {
                                            sum += i;
                                        }
                                    System.out.println (sum);
                                }
                            else
                                {
                                    list.add (Integer.parseInt (read));
                                }
                        }
                    catch (IOException e)
                        {
                        }
                }
            }
    }

    public static void main(String[] args)
        {
T5 t=new T5();
t.start ();
        }
}