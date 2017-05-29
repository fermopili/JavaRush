package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass
{
    public void methodThrowsClassCastException()
        {
        Object ch = new Character('*');
        System.out.println((Byte)ch);
        }

    public void methodThrowsNullPointerException()
        {
        String str=null;
        int l= str.length ( );
        }

    public static void main(String[] args)
        {

        }
}
