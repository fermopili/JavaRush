package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         inputF = reader.readLine ( );
        inputF = "c:/1";

        FileReader fileReader = new FileReader (inputF);

        int           k     = 0;
        int           count = 0;
        StringBuilder sb    = new StringBuilder ( );
        while (fileReader.ready ( ))
            {
                char data = (char) fileReader.read ( );
                sb.append (data);
            }
        Pattern pattern = Pattern.compile ("(?<=(\\s|\\W))world(?=(\\s|\\W))");
        Matcher matcher = pattern.matcher (sb.toString ( ));
        while (matcher.find ( ))
            {
                k++;
            }
        System.out.println (k);
        reader.close ( );
        fileReader.close ( );
        }
}
