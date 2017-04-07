package com.javarush.task.task20.task2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution
{
    public static long[] getNumbers(long N)
        {
        ArrayList<Long> list = new ArrayList<> ( );
        long[]          result;// ={};// new long[0];

        for (long i = 0; i <= N; i++)
            {
                if (i== 0)
                continue;
                if ((i > 0) && (i < 10))
                    {
                        list.add (i);
                        continue;
                    }
                long k = i;
                // calculate lenght number
                int ln = 0;
                do
                    {
                        k = k / 10;
                        ln++;
                    } while (k != 0);
                k = i;
                long summa = 0;
                do
                    {
                        int digit = (int) (k % 10);
                        switch (digit)
                            {
                            case 0:
                                break;
                            case 1:
                                summa = summa + 1;
                                break;
                            case 2:
                                summa = summa + (2 << ln);
                                break;
                            case 4:
                                summa = summa + (2 << (ln * 2));
                                break;
                            case 8:
                                summa = summa + (2 << (ln * 3));
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            case 9:
                                summa = summa + (long) Math.pow (digit, ln);
                                break;
                            }
                        // System.out.print (digit + " ");
                        k = k / 10;
                    } while (k != 0);
                if (summa == i)
                    list.add (i);
            }

        result = new long[list.size ( )];
        for (int i = 0; i < list.size ( ); i++)
            result[i] = list.get (i);
        return result;
        }

    public static void main(String[] args) throws IOException
        {
        //  BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))
        //    long           N      = Long.parseLong (reader.readLine ( ));
        long memoryStart = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        long[] M = getNumbers (Long.MAX_VALUE/20002);
        for (int i = 0; i < M.length; i++)
            System.out.println (M[i]);

        System.out.println();
        long estimatedTime = System.currentTimeMillis() - startTime;
        long totalMem = Runtime.getRuntime().totalMemory();
        long freeMem = Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.println(String.format("Mem : %.2f  Mb.", 1.0 * (totalMem - memoryStart )/ (1024 * 1024)));
        System.out.println(String.format("Time: %.3f sec.", estimatedTime / 1000.0));



        }
}
