package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }
/*    public static void prt(String name,  StackTraceElement[] ste)
    { int i=0;
        System.out.println(name);
        for (StackTraceElement element : ste)
        {System.out.print((i++)+"  ");
            System.out.println(element.getMethodName());
        }
    }
*/
    public static String method1() {
        method2();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        prt("  method1()     ",ste);
        return ste[2].getMethodName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        prt("  method2()     ",ste);
        return ste[2].getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        prt("  method3()     ",ste);
        return ste[2].getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        prt("  method4()     ",ste);
        return ste[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код

        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        prt("  method5()     ",ste);
        return ste[2].getMethodName();
    }
}
