package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader  = new BufferedReader (new InputStreamReader (System.in));
        String         inputF  = reader.readLine ( );
        String         outputF = reader.readLine ( );
       //   inputF = "c:/1";
        //   outputF = "c:/2";
        //  FileReader fileReader = new FileReader (inputF);
        //   FileWriter fileWriter = new FileWriter (outputF);
        BufferedReader fileReader = new BufferedReader (new FileReader (inputF));
        BufferedWriter fileWriter = new BufferedWriter (new FileWriter (outputF));
        String         s;
        StringBuilder  sb         = new StringBuilder ( );
        while (fileReader.ready ( ))
            {
                char data = (char) fileReader.read ( );
                sb.append (data);

            }
        s = sb.toString ( );
        s= s.replaceAll("\\W","");
       fileWriter.write (s);
        reader.close ( );
        fileReader.close ( );
        fileWriter.close ( );
        }
}
