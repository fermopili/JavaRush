package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution
{
    public static void main(String[] args) throws IOException
        {

        String     outputFileName = args[0];
        List<File> parts          = new ArrayList<> ( );
        for (int i = 1; i <  args.length; i++)
            {
                parts.add (new File (args[i]));
            }

        Collections.sort (parts);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream ( );

        for (File part : parts)
            {
                Files.copy (part.toPath ( ), byteArrayOutputStream);
            }

        ZipInputStream zipInputStream = new ZipInputStream (new ByteArrayInputStream (byteArrayOutputStream.toByteArray ( )));
        ZipEntry       zipEntry = zipInputStream.getNextEntry ( );

        FileOutputStream fileOutputStream = new FileOutputStream (outputFileName);
        if (zipEntry != null)
            {
                byte[] buffer = new byte[1024]; //size selected for buffer to avoid out of memory
                int    len;
                System.out.println (zipEntry.getSize ( ));
                System.out.println ((int) zipEntry.getSize ( ));
                while ((len = zipInputStream.read (buffer)) > 0)
                    {
                        fileOutputStream.write (buffer, 0, len);
                    }
                fileOutputStream.flush ( );
                fileOutputStream.close ( );
            }

        zipInputStream.closeEntry ( );
        zipInputStream.close ( );
        byteArrayOutputStream.close ( );
        }
}