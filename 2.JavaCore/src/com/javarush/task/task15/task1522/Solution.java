package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution
{
    public static void main(String[] args)
        {

        }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static
        {

            //     Solution.
            try
                {
                    readKeyFromConsoleAndInitPlanet();
                }
            catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException
        {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String         key    = reader.readLine();
        if (Planet.EARTH.contains(key))
            thePlanet=Earth.getInstance();
        else if (Planet.MOON.contains(key))
            thePlanet=Moon.getInstance();
        else if (Planet.SUN.contains(key))
            thePlanet=Sun.getInstance();
        else thePlanet=null;

        }
}
