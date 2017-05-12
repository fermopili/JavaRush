package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution
{
    public static void main(String[] args)
        {
        Solution   solution   = new Solution ( );
        Properties properties = solution.getProperties ("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list (System.out);

        properties = solution.getProperties ("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list (System.out);

        properties = solution.getProperties ("src/com/javarush/task/task31/task3109/notExists");
        properties.list (System.out);
        // properties = solution.getProperties ("c:/data.properties");
        // properties.list (System.out);
        }

    public Properties getProperties1(String fileName)
        {


        File       file       = new File (fileName);
        Properties properties = new Properties ( );
        try
            {
                properties.load (new FileReader (file));
            }
        catch (IOException e)
            {
                return properties;
            }

        return properties;
        }

    public Properties getProperties(String fileName)
        {
        Properties properties = new Properties ( );
        try
            {
                if (fileName.endsWith (".xml"))
                    properties.loadFromXML (new FileInputStream (Paths.get (fileName).toAbsolutePath ( ).toString ( )));
                else
                    properties.load (new FileReader (Paths.get (fileName).toAbsolutePath ( ).toString ( )));

                return properties;
            }
        catch (IOException ignored)
            {
                return new Properties ( );
            }
        }

    public Properties getProperties2(String fileName)
        {
        Properties properties = new Properties ( );
        try

            {
                File   fileProp  = new File (fileName);
                int    extPoint  = fileName.lastIndexOf ('.');
                String extension = fileName.substring (extPoint + 1);
                if (extension.equals ("xml"))
                    {
                        FileInputStream fis = new FileInputStream (fileProp);
                        properties.loadFromXML (fis);
                        return properties;
                    }
                if (extension.equals ("txt"))
                    {
                        properties.load (new FileReader (fileProp));
                    }
            }
        catch (
                Exception e)

            {
                Properties properties1 = new Properties ( );
                return properties1;
            }
        return properties;
        }
}
