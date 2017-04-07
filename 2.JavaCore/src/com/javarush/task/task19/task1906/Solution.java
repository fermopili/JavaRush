package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader     = new BufferedReader (new InputStreamReader (System.in));
        String         inputF     = reader.readLine ( );
        String         outputF    = reader.readLine ( );
     //   inputF="c:/1";
      //  outputF="c:/2";
        FileReader     fileReader = new FileReader (inputF);
        FileWriter     fileWriter = new FileWriter (outputF);
        int            k          = 0;
        while (fileReader.ready ( ))
            {
                int data = fileReader.read ( );
                k++;
                if ((k % 2) == 0)
                    fileWriter.write (data);
            }
        reader.close ( );
        fileReader.close ( );
        fileWriter.close ( );
        }
}
