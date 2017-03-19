package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution
{
    public static void main(String[] args) throws InterruptedException
        {
        //Add your code here - добавь код тут
        TestThread tr = new TestThread();
        tr.start();
        tr.interrupt();
        }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread
    {
       public void run()// метод можно не пасать валидация проходит и без него
            {
            while (!isInterrupted())
                {
                }
            }

    }
}