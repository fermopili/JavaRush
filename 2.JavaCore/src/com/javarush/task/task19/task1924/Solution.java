package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
Замена чисел
*/

public class Solution
{
    public static Map<Integer, String> map = new HashMap<Integer, String> ( );
    static
        {   map.put (0, "ноль");
            map.put (1, "один");
            map.put (2, "два");
            map.put (3, "три");
            map.put (4, "четыре");
            map.put (5, "пять");
            map.put (6, "шесть");
            map.put (7, "семь");
            map.put (8, "восемь");
            map.put (9, "девять");
            map.put (10, "десять");
            map.put (11, "одиннадцать");
            map.put (12, "двенадцать");
        }
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         inputF = reader.readLine ( );
      //  inputF = "c:/1";
        BufferedReader fileReader = new BufferedReader (new FileReader (inputF));
        while (fileReader.ready ( ))
            {
                String   str  = fileReader.readLine ( );
                String[] strA = str.split (" ");
                str = "";
                for (String s : strA)
                    {
                        try
                            {
                                int d = Integer.parseInt (s);
                                if ((d >= 0) && (d <= 12))
                                    {
                                        str = str +  map.get (d)+" ";
                                    }
                                else {str = str + s + " ";}
                            }
                        catch (NumberFormatException e)
                            {
                                str = str + s + " ";
                            }
                    }
                System.out.println (str);
            }
        fileReader.close ( );
        reader.close ( );
        }
}
