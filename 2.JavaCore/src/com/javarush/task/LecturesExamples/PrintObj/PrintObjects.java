package com.javarush.task.LecturesExamples.PrintObj;

import com.javarush.task.LecturesExamples.SaveCat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 28.03.2017.
 */
public class PrintObjects
{
    public static void main(String[] args) throws Exception
        {
       //   Cat cat = new Cat ("hhhhhhhhhhhhhhhhhhh", 3, 33);
     //   cat.save (System.out);
      //     cat.save (new FileOutputStream ("c:/2"));
      //  Cat c = new Cat ( ).loadO (new FileInputStream ("c:/2" ));
      //  c.save (System.out);
        Human human = new Human ();
        human.dog=new Dog ();
        human.cat=new Cat ();
        human.save (new FileOutputStream ("c:/3" ));
        human.load (new FileInputStream ("c:/3" ));
        human.save (System.out);
        }
}
