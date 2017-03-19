package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
 /*   public static void main2(String[] args) {
       System.out.println(isDateOdd("MAY 1 2013"));
     //   System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {

        Date dt=new Date(date);
        int y=  dt.getYear();
        Date dt1=new Date(dt.getYear(),0,1,0,0,0);
        int value= (int) ((dt.getTime()-dt1.getTime())/(1000*60*60*24))+1;
     //  System.out.println(value);
        if(value%2!=0)
            return true;
        return false;

    }
//----------------------------------
*/
    public static void main(String[] args)
    {System.out.println("m");
        method1();
    }

    public static void method1()
    {System.out.println("m1");
        method2();
    }

    public static void method2()
    {System.out.println("m2");
        method3();
    }

    public static void method3()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            System.out.println(element.getMethodName());
        }
    }









//----------------------------------------------------------------
}
