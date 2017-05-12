package com.javarush.task.task32.task3210;

import java.io.*;

/* 
Используем RandomAccessFile
*/

public class Solution
{
    public static void main(String... args) //throws IOException
        {
      /*  String           fileName = args[0];
        int              pos      = Integer.parseInt (args[1]);
        String           text     = args[2];
        RandomAccessFile raf      = new RandomAccessFile (fileName, "rw");
        byte[]           b        = new byte[text.length ( )];
        raf.seek (pos);
        raf.read (b, 0, text.length ( ));
        String str = new String (b);
        raf.seek (raf.length ( ));
        if (str.equals (text))
            raf.write ("true".getBytes ());
        else
            raf.write ("false".getBytes ());
        raf.close ( );
        */
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";

        //это строчка – ключевая: мы «превратили» строку в Reader
        try (StringReader reader = new StringReader (test))
            {

                executor (reader);
            }
        catch(Exception E)
            {}

        }
    public static void executor(Reader reader) throws Exception
        {
        BufferedReader br = new BufferedReader(reader);
        boolean r=true;
        String line;
        while ( (line=br.readLine())!=null)
            {

                System.out.println(line);

            }
        }
}
