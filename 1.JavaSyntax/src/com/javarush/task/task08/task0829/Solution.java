package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String> ( );
        while (true)
            {
                String family = reader.readLine ( );
                if (family.isEmpty ( )) break;

                addresses.add (family);
            }
         /*
        //read home number
        int houseNumber = Integer.parseInt (reader.readLine ( ));
        if (0 <= houseNumber && houseNumber < addresses.size ( ))
            {
                String familySecondName = addresses.get (houseNumber);
                System.out.println (familySecondName);
            }
        */
        String str = reader.readLine ( );
        for (int i = 0; i < addresses.size ( ); i++)
            {
                if (str.equals (addresses.get (i)))
                    {
                        System.out.println (addresses.get (i +1));
                        break;
                    }
            }
        }
}
