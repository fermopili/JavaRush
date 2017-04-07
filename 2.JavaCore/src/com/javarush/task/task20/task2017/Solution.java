package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution
{
    public A getOriginalObject(ObjectInputStream objectStream)
        {
        Object a = null;
        try
            {
                a = objectStream.readObject ( );
            }
        catch (IOException e)
            {
                //  e.printStackTrace ( );
                System.out.println (e.getMessage ( ));
                return null;
            }
        catch (ClassNotFoundException e)
            {
                //  e.printStackTrace ( );
                System.out.println (e.getMessage ( ));
                return null;
            }
        finally
            {
                if (a instanceof A)
                    return (A) a;
                else return null;
            }

        }

    public class A implements Serializable
    {
    }

    public class B extends A
    {
        public B()
            {
            System.out.println ("inside B");
            }
    }

    public static void main(String[] args)
        {

        }
}
