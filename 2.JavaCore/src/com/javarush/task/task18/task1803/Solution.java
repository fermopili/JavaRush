package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* 
Самые частые байты
*/
public  class Solution
{
   static  Object t=new Solution();
    static
        {
            System.out.println (t);
        }
    public static void main(String[] args) throws Exception
        {

        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF;//  = reader.readLine ( );
        nameF="c:/1.txt";
        FileInputStream           inputStream = new FileInputStream (nameF);
       // Map<Integer, Integer> map         = new HashMap<> ( );
        Map<Integer, Integer> map         = new TreeMap<> ( );
        //Map<Character, Integer> map = new TreeMap ( );
        int                       max         = 0;
        while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
            {
                int data = Integer.valueOf (inputStream.read ( )); //прочитать очередной байт
                if (map.containsKey (data))
                    {
                        int value = map.get (data);
                        map.replace (data, value + 1);
                        if ((value + 1) > max)
                            max = value + 1;
                    }
                else
                    {
                        map.put (data, 1);
                    }
            }
        System.out.println ("max="+max);
        Iterator it = map.entrySet ( ).iterator ( );
        while (it.hasNext ( ))
            {
                HashMap.Entry pair = (Map.Entry) it.next ( );
               // if (pair.getValue ( ).equals (max))

                    System.out.println ((char )(int) pair.getKey ( ) +" "+ pair.getValue ());
            }
        reader.close ( );
        inputStream.close ( ); // закрываем поток
        }
}
