package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        method2();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
      //  System.out.println( "  method1(); " +ste[2].getLineNumber()+"  "+ste[2].getMethodName());
        return  ste[2].getLineNumber();
    }

    public static int method2() {
        method3();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
     //   System.out.println( "  method2(); " +ste[2].getLineNumber()+"  "+ste[2].getMethodName());
        return ste[2].getLineNumber();
    }

    public static int method3() {
        method4();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
     //   System.out.println( "  method3(); " +ste[2].getLineNumber()+"  "+ste[2].getMethodName());
        return ste[2].getLineNumber();
    }

    public static int method4() {
        method5();
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
       // System.out.println( "  method4(); " +ste[2].getLineNumber()+"  "+ste[2].getMethodName());
        return  ste[2].getLineNumber();
    }

    public static int method5() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
       // System.out.println( "  method5(); " +ste[2].getLineNumber()+"  "+ste[2].getMethodName());
        return  ste[2].getLineNumber();
    }
}
