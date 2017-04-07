package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer> ( );

    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         name;
        while (!(name = reader.readLine ( )).contains ("exit"))
            {
                new ReadThread (name).start ( );

            }
       //    System.out.println (resultMap);
        reader.close ( );
        }

    public static class ReadThread extends Thread
    {
        String fileName;

        public ReadThread(String fileName)
            {
            //implement constructor body
            this.fileName = fileName;
            }

        @Override
        public void run()
            {
            super.run ( );
            try
                {
                    int res = readMax (fileName);
                    resultMap.put (fileName, res);
                }
            catch (IOException e)
                {
                    e.printStackTrace ( );
                }
            }
        // implement file reading here - реализуйте чтение из файла тут
        public int readMax(String fileName) throws IOException
            {
            FileInputStream           inputStream = new FileInputStream (fileName);
            HashMap<Integer, Integer> map         = new HashMap<> ( );
            int                       max         = 0;
            while (inputStream.available ( ) > 0) //пока остались непрочитанные байты
                {
                    int data = Integer.valueOf (inputStream.read ( )); //прочитать очередной байт
                    if (map.containsKey (data))
                        {
                            int value = map.get (data);
                            map.replace (data, value + 1);
                            if ((value + 1) > max)
                                max = value + 1;
                        }
                    else
                        {
                            map.put (data, 1);
                        }
                }
            inputStream.close ( ); // закрываем поток
            Iterator it = map.entrySet ( ).iterator ( );
            while (it.hasNext ( ))
                {
                    HashMap.Entry pair = (Map.Entry) it.next ( );
                    if (pair.getValue ( ).equals (max))
                        {
                            return (int) pair.getKey ( );
                        }
                }
            return max;
            }
    }
}
