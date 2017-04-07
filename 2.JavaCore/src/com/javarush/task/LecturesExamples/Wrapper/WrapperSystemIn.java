package com.javarush.task.LecturesExamples.Wrapper;

import java.io.*;

/**
 * Created by Administrator on 22.03.2017.
 */
public class WrapperSystemIn
{public static InputStream is ;
    public static void main(String[] args) throws IOException
        {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder ( );
        sb.append ("Lena").append ('\n');
        sb.append ("Olya").append ('\n');
        sb.append ("Anya").append ('\n');
        String data = sb.toString ( );

        is = new ByteArrayInputStream (data.getBytes ());
        //Оборачиваем строку в класс ByteArrayInputStream
     //  InputStream is = new ByteArrayInputStream (data.getBytes ( ));

        //подменяем in
        System.setIn (is);


        //вызываем обычный метод, который не подозревает о наших манипуляциях
        readAndPrintLine ( );
        is = new ByteArrayInputStream ("data.kkkkkkkkkkkkkkkkkkkkkkkgetBytes ( )".getBytes ());

        System.setIn (is);

        readAndPrintLine ( );
        }

    public static void readAndPrintLine() throws IOException
        {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         InputStreamReader isr    = new InputStreamReader (System.in);
        BufferedReader    reader = new BufferedReader (isr);
int k=0;
        while (true)
            {
                String line = reader.readLine ( );
                if (line == null) break;
                System.out.println ((++k)+"  "+line);
            }
        isr.close ( );
        isr    = new InputStreamReader (System.in);
        reader = new BufferedReader (isr);

        String line = reader.readLine ( );
       System.out.println ("new is  "+line);

        reader.close ( );

        }
}
