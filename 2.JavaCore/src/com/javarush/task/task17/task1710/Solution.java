package com.javarush.task.task17.task1710;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/
public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person> ( );

    static
        {
            allPeople.add (Person.createMale ("Иванов Иван", new Date ( )));  //сегодня родился    id=0
            allPeople.add (Person.createMale ("Петров Петр", new Date ( )));  //сегодня родился    id=1
        }

    public static void main(String[] args) throws ParseException
        {
        //start here - начни тут
        if ("-c".equals (args[0]))
            {
                Date             dt = new Date ( );
                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault ( ));
                dt = ft.parse (args[3]);
                if ("ж".equals (args[2]))
                    allPeople.add (Person.createFemale (args[1], dt));
                else
                    allPeople.add (Person.createMale (args[1], dt));
                System.out.println (allPeople.size ( ) - 1);
            }
        if ("-u".equals (args[0]))
            {
                allPeople.get (Integer.parseInt (args[1])).setName (args[2]);
                if ("ж".equals (args[3]))
                    allPeople.get (Integer.parseInt (args[1])).setSex (Sex.FEMALE);
                else
                    allPeople.get (Integer.parseInt (args[1])).setSex (Sex.MALE);
                Date             dt = new Date ( );
                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault ( ));
                dt = ft.parse (args[4]);
                allPeople.get (Integer.parseInt (args[1])).setBirthDay (dt);
            }
        if ("-d".equals (args[0]))
            {
                allPeople.get (Integer.parseInt (args[1])).setName (null);
                allPeople.get (Integer.parseInt (args[1])).setSex (null);
                allPeople.get (Integer.parseInt (args[1])).setBirthDay (null);
            }
        if ("-i".equals (args[0]))
            {
                String strName = allPeople.get (Integer.parseInt (args[1])).getName ( );
                String strSex;
                if (allPeople.get (Integer.parseInt (args[1])).getSex ( ) == Sex.FEMALE)
                    strSex = "ж";
                else
                    strSex = "м";
                Date             dt      = allPeople.get (Integer.parseInt (args[1])).getBirthDay ( );
                SimpleDateFormat sdf     = new SimpleDateFormat ("dd-MMM-yyyy", Locale.ENGLISH);
                String           strDate = sdf.format (dt);
                System.out.println (strName + " " + strSex + " " + strDate);

            }
  /*     System.out.println ("-------------------------------------------------");
        for( int i=0;i<allPeople.size ();i++)
            {
                String strName = allPeople.get (i).getName ( );
                String strSex;
                if (allPeople.get (i).getSex ( ) == Sex.FEMALE)
                    strSex = "ж";
                else
                    strSex = "м";
                Date             dt      = allPeople.get (i).getBirthDay ( );
                SimpleDateFormat sdf     = new SimpleDateFormat ("dd-MMM-yyyy", Locale.ENGLISH);
                String           strDate = sdf.format (dt);
                System.out.println (strName + " " + strSex + " " + strDate);
            }
*/
        }
}
