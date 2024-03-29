package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString ( );

    public static void main(String[] args)
        {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ( );
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream (outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut (stream);
        testString.printSomething ( );

        String result = outputStream.toString ( ).replaceAll ("te", "??");

        //Возвращаем все как было
        System.setOut (consoleStream);
        System.out.println (result);
        }

    public static class TestString
    {
        public void printSomething()
            {
            System.out.println ("it's a text for testing");
            }
    }
}
