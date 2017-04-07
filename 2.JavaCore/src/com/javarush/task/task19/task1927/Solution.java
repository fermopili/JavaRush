package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

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
        String         publisity = "JavaRush - курсы Java онлайн";
        String         result    = outputStream.toString ( );
        //Возвращаем все как было
        System.setOut (consoleStream);

        int counter = 0;
        for (String s : result.split("\n"))
            {
                System.out.println (s);
                counter++;
                if (counter % 2 == 0)
                    {
                        System.out.println (publisity);
                    }
            }

      //  PrinterWrapper pr=new PrinterWrapper (System.out);

        }

    public static class PrinterWrapper extends PrintStream
    {
        private static int counter = 0;

        public PrinterWrapper(PrintStream s)
            {
            super (s);
            }

        @Override
        public void println(String s)
            {
            counter++;
            super.println (s);
            if (counter % 2 == 0)
                {
                    super.println ("Java Rush - курсы Java онлайн");
                }

            }

    }
    public static class TestString
    {
        public void printSomething()
            {
            System.out.println ("first");
            System.out.println ("second");
            System.out.println ("third");
            System.out.println ("fourth");
            System.out.println ("fifth");
            }
    }
}
