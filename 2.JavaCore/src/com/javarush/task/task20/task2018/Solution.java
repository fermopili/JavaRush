package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution
{
    public static class A
    {


        protected String name = "A";

        public A(String name)
            {
            this.name += name;
            }

    }

    public class B extends A implements Serializable
    {

        public B(String name)
            {
            super (name);
            this.name += name;
            }
        public void writeObject(ObjectOutputStream objectOutputStream) throws IOException
            {
            objectOutputStream.defaultWriteObject ( );
            objectOutputStream.writeObject (name);
            }

        public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException
            {
            objectInputStream.defaultReadObject ( );
            this.name = (String) objectInputStream.readObject ( );
            }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
        {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream ( );
        ObjectOutputStream    oos               = new ObjectOutputStream (arrayOutputStream);

        Solution solution = new Solution ( );
        B        b        = solution.new B ("B2");
        System.out.println (b.name);

        oos.writeObject (b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream (arrayOutputStream.toByteArray ( ));
        ObjectInputStream    ois              = new ObjectInputStream (arrayInputStream);

        B b1 = (B) ois.readObject ( );
        System.out.println (b1.name);
        }


}
