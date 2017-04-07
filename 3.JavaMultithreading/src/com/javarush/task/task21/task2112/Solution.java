package com.javarush.task.task21.task2112;

public class Solution
{
    public static void main(String[] args)
        {
        DBConnectionManager dbConnectionManager = new DBConnectionManager ( );

        Integer i = new Integer(1);
        Integer j = new Integer(1);

        System.out.println(i==j);
        System.out.println(i.equals (j));

        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection ( ))
            {
                System.out.println ("Entering the body of try block.");
                fakeConnection.usefulOperation ();
                fakeConnection.unsupportedOperation ();
            }
        catch (Exception e)
            {
            }
        }
}
