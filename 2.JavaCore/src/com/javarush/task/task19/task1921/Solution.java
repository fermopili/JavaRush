package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person> ( );

    public static void main(String[] args) throws IOException, ParseException
        {
        FileReader     fr      = new FileReader (args[0]);
        BufferedReader readerF = new BufferedReader (fr);
        while (readerF.ready ( ))
            {
                String   str  = readerF.readLine ( );
                String[] strA = str.split (" ");
                int      y    = Integer.parseInt (strA[strA.length - 1]);
                int      m    = Integer.parseInt (strA[strA.length - 2]);
                int      d    = Integer.parseInt (strA[strA.length - 3]);
                String   fio  = "";
                for (int i = 0; i < strA.length - 3; i++)
                    {
                        if (fio.length ( ) != 0)
                            fio = fio + " ";
                        fio = fio + strA[i];
                    }
                Date             dtOut = new Date ( );
                SimpleDateFormat ft    = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault ( ));
                dtOut = ft.parse (d + "/" + m + "/" + y);
                Person pr = new Person (fio, dtOut);
                PEOPLE.add (pr);
                //   Date             dtIn    = pr.getBirthday ( );
                //   SimpleDateFormat sdf     = new SimpleDateFormat ("dd/MM/yyyy", Locale.ENGLISH);
                //   String           strDate = sdf.format (dtIn);
                //   System.out.println ("|" + pr.getName ( ) + "|  " + strDate);
            }
        fr.close ( );
        }
}
