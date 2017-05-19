package com.javarush.task;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Administrator on 16.05.2017.
 */
public class TestMaps
{

    public static void main(String[] args)
        {
        HashMap<Integer, String> hashMap = new HashMap ( );
        TreeMap<Integer, String> treeMap = new TreeMap ( );
        long                     start;
        long                     end;
        long                     hashTime;
        long                     treeTime;

       // for (int i = 0; i < 1_000_000; i++)
            for (int i = 0; i < 10; i++)
            {
             //  hashMap.put (new Integer ((int) Math.random ( ) * 1000000), genRandString ((int) Math.round (Math.random ( ) * 36)).toString ( ));
            //    treeMap.put (new Integer ((int) Math.random ( ) * 1000000), genRandString ((int) Math.round (Math.random ( ) * 36)).toString ( ));
                hashMap.put (new Integer (i), genRandString ((int) Math.round (Math.random ( ) * 36)).toString ( ));
                treeMap.put (new Integer (i), genRandString ((int) Math.round (Math.random ( ) * 36)).toString ( ));

            }

        start = System.currentTimeMillis ( );
     /*  for (int i = 0; i < 10_000_000; i++)
            {
                String s = hashMap.get (new Integer ((int) Math.random ( ) * 1000000));
            }
        */
     System.out.println (hashMap);
     String d=   hashMap.put (new Integer (33), "genRandString ((int");

        System.out.println (hashMap);
        d=   hashMap.put (new Integer (33), "genRandString ((int");
        System.out.println (hashMap);
        System.out.println (hashMap.size ());
        System.out.println (treeMap.size ());
        end = System.currentTimeMillis ( );
        hashTime = end - start;
        System.out.println ("Затраченное время на перебор hashMap (ms): " + hashTime);

        start = System.currentTimeMillis ( );
        for (int i = 0; i < 10_000_000; i++)
            {
                String s = treeMap.get (new Integer ((int) Math.random ( ) * 1000000));
            }

        end = System.currentTimeMillis ( );
        treeTime = end - start;
        System.out.println ("Затраченное время на перебор treeMap (ms): " + treeTime);

        }

    static StringBuilder genRandString(int lenght)
        {
        String        symbols    = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder randString = new StringBuilder ( );
        for (int i = 0; i < lenght; i++)
            randString.append (symbols.charAt ((int) (Math.random ( ) * symbols.length ( ))));
        return randString;

        }
}