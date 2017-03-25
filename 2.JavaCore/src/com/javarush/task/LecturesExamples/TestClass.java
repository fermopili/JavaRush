package com.javarush.task.LecturesExamples;

/**
 * Created by Administrator on 22.03.2017.
 */
public class TestClass
{
    public static void main(String[] args)
        {
        Cat cat     = new Cat ("Васька ");
        Cat catWrap = new CatWrapper (cat);
        printName (catWrap);
        }
    public static void printName(Cat named)
        {
        System.out.println (named.getName ( ));
        }

}
