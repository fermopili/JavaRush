package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( System.in ) );
        System.out.println ( "Input a roman number to be converted to decimal: " );
        String romanString = bufferedReader.readLine ( );
        //    romanString="CM";
        System.out.println ( "Conversion result equals " + romanToInteger ( romanString ) );
        }

    public static int romanToInteger(String s)
        {
        StringBuffer stringBuffer = new StringBuffer ( s.trim ( ) );
        Map<Integer, String> patterns = new LinkedHashMap<> ( );
        patterns.put ( 3000, "MMM" );
        patterns.put ( 2000, "MM" );
        patterns.put ( 900, "CM" );
        patterns.put ( 1000, "M" );
        patterns.put ( 800, "DCCC" );
        patterns.put ( 700, "DCC" );
        patterns.put ( 600, "DC" );
        patterns.put ( 400, "CD" );
        patterns.put ( 500, "D" );
        patterns.put ( 300, "CCC" );
        patterns.put ( 200, "CC" );
        patterns.put ( 90, "XC" );
        patterns.put ( 100, "C" );
        patterns.put ( 80, "LXXX" );
        patterns.put ( 70, "LXX" );
        patterns.put ( 60, "LX" );
        patterns.put ( 40, "XL" );
        patterns.put ( 50, "L" );
        patterns.put ( 30, "XXX" );
        patterns.put ( 20, "XX" );
        patterns.put ( 9, "IX" );
        patterns.put ( 10, "X" );
        patterns.put ( 8, "VIII" );
        patterns.put ( 7, "VII" );
        patterns.put ( 6, "VI" );
        patterns.put ( 4, "IV" );
        patterns.put ( 5, "V" );
        patterns.put ( 3, "III" );
        patterns.put ( 2, "II" );
        patterns.put ( 1, "I" );

        int result = 0;
        for (Map.Entry<Integer, String> pair : patterns.entrySet ( ))
            {
                int pos = stringBuffer.indexOf ( pair.getValue ( ) );
                if (pos >= 0)
                    {
                        result += pair.getKey ( );
                        stringBuffer.delete ( pos, pos + pair.getValue ( ).length ( ) );
                    }
            }
        return result;
        }


    public static int romanToInteger1(String s) throws IOException
        {
        char[] simbols   = s.toCharArray ( );
        int    result    = 0;
        char   oldSimbol = simbols[0];
        for (int i = simbols.length - 1; i >= 0; i--)
            {
                result += getValueSimbol ( simbols[i] );
                if (getValueSimbol ( oldSimbol ) < getValueSimbol ( simbols[i] ))
                    result -= (getValueSimbol ( oldSimbol ) * 2);
            }
        return result;
        }

    public static int getValueSimbol(char simbol) throws IOException
        {
        switch (simbol)
            {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

            }
        throw new IOException ( );
        }
}
