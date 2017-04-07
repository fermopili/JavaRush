package com.javarush.task.LecturesExamples.SerialCat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 28.03.2017.
 */
public class Solution
{
    public static void main(String[] args) throws Exception
        {
        Cat cat = new Cat();

        //save cat to file
        FileOutputStream   fileOutput   = new FileOutputStream("cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(cat);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream   fiStream     = new FileInputStream("cat.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object            object       = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        Cat newCat = (Cat)object;
        if(cat.hashCode ()==newCat.hashCode ())
            System.out.println ("YES");
        else
            System.out.println ("NO");
        }
}
