package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
*/

public class Solution implements Person
{
    public static void main(String[] args) throws Exception
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person         person = null;
        String         key    = null;
        while (true)
            {
                key = reader.readLine();
                if ("user".equals(key))
                    person = new User();
                else if ("loser".equals(key))
                    person = new Loser();
                else if ("coder".equals(key))
                    person = new Coder();
                else if ("proger".equals(key))
                    person = new Proger();
                else
                    break;
                doWork(person); //вызываем doWork
            }
        }

    public static void doWork(Person person)
        {
        if (person instanceof User)
            ((User) person).live();
        if (person instanceof Loser)
            ((Loser) person).doNothing();
        if (person instanceof Coder)
            ((Coder) person).coding();
        if (person instanceof Proger)
            ((Proger) person).enjoy();
        }
}
