package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
        {
    BufferedReader reader  = new BufferedReader (new InputStreamReader (System.in));
    String          inputF  = reader.readLine ( );
    String          outputF = reader.readLine ( );

        BufferedReader   fileReader=new BufferedReader(new FileReader (inputF));
        BufferedWriter   fileWriter=new BufferedWriter(new FileWriter (outputF));

        StringBuilder sb    = new StringBuilder ( );
        while (fileReader.ready ( ))
            {
                char data = (char) fileReader.read ( );
                sb.append (data);
            }
        String[] str=sb.toString ().split (" ");
       // Pattern pattern = Pattern.compile ("(\\s([0-9]+)\\s)|(([0-9]+)\\s)|(\\s([0-9]+))");
     //   Pattern pattern = Pattern.compile ("(([0-9a-zA-Z]+))");
     //   Matcher matcher = pattern.matcher (sb.toString ( ));
        for(int i=0;i<str.length;i++)
            {
                if(str[i].matches ("([0-9]+)"))
                    fileWriter.write (str[i]+" ");
            }
        reader.close ( );
    fileReader.close ( );
    fileWriter.close ( );
    }
}
