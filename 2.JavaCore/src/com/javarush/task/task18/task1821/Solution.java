package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        String nameF ;//= args[0];
        nameF="c:/1.txt";
        FileInputStream         f1  = new FileInputStream (nameF);
        Map<Character, Integer> map = new TreeMap ( );
        int                     ch;
        while ((ch = f1.read ( )) != -1)
            {
                if (map.containsKey ((char) ch))
                    {
                        map.put ((char) ch, map.get ((char) ch) + 1);
                    }
                else
                    {
                        map.put ((char) ch, 1);
                    }
            }
        for (Map.Entry pair : map.entrySet ( ))
            {
                System.out.println (pair.getKey ( ) + " " + pair.getValue ( ));
            }
        f1.close ( );
        }
}
