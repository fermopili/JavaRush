package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader  = new BufferedReader (new InputStreamReader (System.in));
        String         inputF  = reader.readLine ( );
        String         outputF = reader.readLine ( );
      //  inputF = "c:/1";
      //  outputF = "c:/2";
      //  FileReader fileReader = new FileReader (inputF);
     //   FileWriter fileWriter = new FileWriter (outputF);
        BufferedReader fileReader = new BufferedReader (new FileReader (inputF));
        BufferedWriter fileWriter = new BufferedWriter (new FileWriter (outputF));
        while (fileReader.ready ( ))
            {
                char data = (char) fileReader.read ( );
                if (data == '.')
                    data = '!';
                fileWriter.write (data);
            }
        reader.close ( );
        fileReader.close ( );
        fileWriter.close ( );
        }
}
