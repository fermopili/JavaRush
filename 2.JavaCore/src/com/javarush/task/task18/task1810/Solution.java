package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws DownloadException, IOException
        {
        while (true)
            {  BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
                String         nameF  = reader.readLine ( );

                FileInputStream inputStream = new FileInputStream (nameF);
                if (inputStream.available ( ) < 1000) //пока остались непрочитанные байты
                    {   reader.close ( );
                        inputStream.close ( );
                        throw new DownloadException ( );
                    }
                System.out.println (nameF);
            }
        }
    public static class DownloadException extends Exception
    {

    }
}
