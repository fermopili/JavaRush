package com.javarush.task.task31;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 05.05.2017.
 */
public class AClass
{
    public static void main(String[] args) throws IOException
        {
        FileOutputStream zipFile = new FileOutputStream ("c:/archive.zip");
        ZipOutputStream  zip     = new ZipOutputStream (zipFile);

//кладем в него ZipEntry – «архивный объект»
        ZipEntry zipEntry = new ZipEntry ("66666666");

        zip.putNextEntry (new ZipEntry ("zzzzz.txt"));
        zip.putNextEntry (new ZipEntry ("33333.txt"));
//копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        File file = new File ("c:/22.ttt");
        Files.copy (file.toPath ( ), zip);

        zip.putNextEntry (zipEntry);
        byte[] b = {0x55, 0x55, 0x55, 0x55, 0x55, 0x55, 0x55, 0x55, 0x33};
        zip.write (b);
        zip.close ( );
// закрываем архив
        zip.close ( );
ff();

        }

    static void ff() throws IOException
        {//файл, который хранит свойства нашего проекта
        File file1 = new File("c:/data.properties");

//создаем объект Properties и загружаем в него данные из файла.
        Properties properties1 = new Properties();
        properties1.setProperty ("email","emailemailemailemailemailemailemailemail");
        properties1.setProperty ("directory","directorydirectorydirectorydirectory");
        properties1.setProperty ("max.size","6666");
        properties1.store (new FileWriter (file1),"rrrrrrrrrrrr");

        File file = new File("c:/data.properties");
        Properties properties = new Properties();
        try
            {
                properties.load(new FileReader (file));
            }
        catch (IOException e)
            {
               System.out.println ( e.getMessage ());
            }
        System.out.println ("000000");
//получаем значения свойств из объекта Properties
        String email = properties.getProperty("email");
        System.out.println ("email = "+email);
        String directory = properties.getProperty("directory");
        System.out.println ("directory = "+directory);
//получаем числовое значение из объекта Properties
        int maxFileSize = Integer.parseInt(properties.getProperty("max.size", "10000"));
        System.out.println ("maxFileSize = "+maxFileSize);
        }
}
