package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution
{
    public static volatile List<Person> allPeople = new ArrayList<Person> ( );

    static
        {
            allPeople.add (Person.createMale ("Иванов Иван", new Date ( )));  //сегодня родился    id=0
            allPeople.add (Person.createMale ("Петров Петр", new Date ( )));  //сегодня родился    id=1
        }

    public static void main(String[] args) throws ParseException
        {
        //start here - начни тут

        switch (args[0])
            {
            case "-c":
                synchronized (allPeople)
                    {
                        _c (args);
                    }
                break;
            case "-u":
                synchronized (allPeople)
                    {
                        _u (args);
                    }
                break;
            case "-d":
                synchronized (allPeople)
                    {
                        _d (args);
                    }
                break;
            case "-i":
                synchronized (allPeople)
                    {
                        _i (args);
                    }

            }
/*
        System.out.println ("-------------------------------------------------");
        for (int i = 0; i < allPeople.size ( ); i++)
            {
                String strName = allPeople.get (i).getName ( );
                String strSex=null;
                if (allPeople.get (i).getSex ( ) == Sex.FEMALE)
                    strSex = "ж";
                if (allPeople.get (i).getSex ( ) == Sex.MALE)
                    strSex = "м";
                Date             dt  = allPeople.get (i).getBirthDay ( );
                SimpleDateFormat sdf = new SimpleDateFormat ("dd-MMM-yyyy", Locale.ENGLISH);
                String strDate = null;
                try
                    {
                        strDate = sdf.format (dt);
                    }
                catch (NullPointerException e)
                    {
                    }
                System.out.println (strName + " " + strSex + " " + strDate);
            }
*/
        }

    public static void _c(String[] args) throws ParseException
        {
        for (int index = 1; index < args.length; index += 3)
            {
                Date             dt;// = new Date ( );
                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault ( ));
                dt = ft.parse (args[index + 2]);
                if ("ж".equals (args[index + 1]))
                    allPeople.add (Person.createFemale (args[index], dt));
                else
                    allPeople.add (Person.createMale (args[index], dt));
                System.out.println (allPeople.size ( ) - 1);
            }
        }

    public static void _u(String[] args) throws ParseException
        {
        for (int index = 1; index < args.length; index += 4)
            {
                allPeople.get (Integer.parseInt (args[index])).setName (args[index + 1]);
                if ("ж".equals (args[index + 2]))
                    allPeople.get (Integer.parseInt (args[index])).setSex (Sex.FEMALE);
                else
                    allPeople.get (Integer.parseInt (args[index])).setSex (Sex.MALE);
                Date             dt;// = new Date ( );
                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault ( ));
                dt = ft.parse (args[index + 3]);
                allPeople.get (Integer.parseInt (args[index])).setBirthDay (dt);
            }
        }

    public static void _d(String[] args)
        {
        for (int index = 1; index < args.length; index++)
            {
                allPeople.get (Integer.parseInt (args[index])).setName (null);
                allPeople.get (Integer.parseInt (args[index])).setSex (null);
                allPeople.get (Integer.parseInt (args[index])).setBirthDay (null);
            }
        }

    public static void _i(String[] args)
        {
        for (int index = 1; index < args.length; index++)
            {
                String strName = allPeople.get (Integer.parseInt (args[index])).getName ( );
                String strSex;
                if (allPeople.get (Integer.parseInt (args[index])).getSex ( ) == Sex.FEMALE)
                    strSex = "ж";
                else
                    strSex = "м";
                Date             dt      = allPeople.get (Integer.parseInt (args[index])).getBirthDay ( );
                SimpleDateFormat sdf     = new SimpleDateFormat ("dd-MMM-yyyy", Locale.ENGLISH);
                String           strDate = sdf.format (dt);
                System.out.println (strName + " " + strSex + " " + strDate);
            }
        }
}
