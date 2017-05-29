package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( System.in ) );
        System.out.println ( "Please input your string: " );
        String s = bufferedReader.readLine ( );
        //   s = "ttttwt";
      //  s = "a123bcbccaa";

        System.out.println ( "The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring ( s ) );
        }

    public static int lengthOfLongestUniqueSubstring(String s)
        {
        if ((s == null) || (s.length ( ) == 0))
            return 0;
        List<Integer> list = new ArrayList<> ( );
        for (int j = 0; j < s.length ( ); j++)
            {
                String string = s.substring ( j, s.length ( ) );
                StringBuffer stringBuffer = new StringBuffer ( );
                stringBuffer.append ( string.charAt ( 0 ) );
                exit:
                for (int i = 1; i < string.length ( ); i++)
                    {
                        for (int k = 0; k < stringBuffer.length ( ); k++)
                            if (stringBuffer.charAt ( k ) == string.charAt ( i ))
                                break exit;

                        stringBuffer.append ( string.charAt ( i ) );
                    }
                list.add ( stringBuffer.toString ( ).length ( ) );
            }
        return Collections.max ( list );
        }
}
