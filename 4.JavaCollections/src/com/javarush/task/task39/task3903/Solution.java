package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

        System.out.println ( "Please type in a number: " );

        long number = Long.parseLong ( reader.readLine ( ) );
        System.out.println ( "Please type in first index: " );
        int i = Integer.parseInt ( reader.readLine ( ) );
        System.out.println ( "Please type in second index: " );
        int j = Integer.parseInt ( reader.readLine ( ) );
        System.out.println ( "The result of swapping bits is " + swapBits ( number, i, j ) );
        }

    public static long swapBits(long number, int i, int j)
        {
        long bitI = (number>>i)&0x01;
        long bitJ = (number>>j)&0x01;
        if (bitI != bitJ)
            number = number & ~((1 << i) | (1 << j)) | (bitI << j) | (bitJ << i);
        return number;
        }
}
