package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        boolean code;
        if ("-e".equals (args[0]))
            code = true;
        else
            code = false;
        String           inputFileName  = args[1];
        String           outputFileName = args[2];
        FileInputStream  inputStream    = new FileInputStream (inputFileName);
        FileOutputStream outputStream   = new FileOutputStream (outputFileName);
        byte[] simbol = new byte[1];
        while (inputStream.available ( ) > 0)
            {
                inputStream.read (simbol);
                if (code)
                    simbol = codeF (simbol);
                else
                    simbol = decodeF (simbol);
                outputStream.write (simbol);
            }
        inputStream.close ( );
        outputStream.close ( );
        }
    private static byte[] codeF(byte[] simbol)
        {
        simbol[0] = (byte) ~simbol[0];
        return simbol;
        }
    private static byte[] decodeF(byte[] simbol)
        {
        simbol[0] = (byte) ~simbol[0];
        return simbol;
        }
}
