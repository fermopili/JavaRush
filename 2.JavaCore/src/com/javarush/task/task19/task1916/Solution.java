package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem> ( );

    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

        String name1 = reader.readLine ( );
        String name2 = reader.readLine ( );
        name1 = "c:/1";
        name2 = "c:/2";
        BufferedReader    readerF1 = new BufferedReader (new FileReader (name1));
        BufferedReader    readerF2 = new BufferedReader (new FileReader (name2));
        ArrayList<String> lines1    = new ArrayList<> ( );
        ArrayList<String> lines2    = new ArrayList<> ( );
        while (readerF1.ready ( ))
            lines1.add (readerF1.readLine ( ));
        while (readerF2.ready ( ))
            lines2.add (readerF2.readLine ( ));
        int    maxLength;
        String s1=null, s2 = null, s3;
        while((maxLength = (lines1.size() > lines2.size()) ? lines1.size() : lines2.size()) != 0){
            // Проверки, чтобы не пытаться получить значение из пустого массива
            if(lines1.size() != 0)
                s1 = lines1.get(0);
            if(lines2.size() != 0)
                s2 = lines2.get(0);
            //Если в первый массив пуст, то очевидно, что во втором массиве осталась лишь одна строка и она ADDED
            if(lines1.size() == 0){
                lines.add(new LineItem(Type.ADDED, s2));
                lines2.remove(0);
            }
            //Аналогично если второй массив пуст, то в первом осталась лишь однда строка и она REMOVED
            else if(lines2.size() == 0){
                lines.add(new LineItem(Type.REMOVED, s1));
                lines1.remove(0);
            }
            // Если строки одинаковы, то удаляем по одной строке из каждого массива
            else if(s1.equals(s2)) {
                lines.add(new LineItem(Type.SAME, s1));
                lines1.remove(0);
                lines2.remove(0);
            }
            //Если текущие строки не равны, то проверяем:
            //Если строка из первого массива равна последующей строке из второго
            //Вылет за границы при проверке lines2.get(1) учтен в первых двух if'ах
            else if(s1.equals(lines2.get(1))){
                lines.add(new LineItem(Type.ADDED, s2));
                lines2.remove(0);
            }
            //Если строка из второго массива равна последующей строке из первого
            //Вылет за границы при проверке lines1.get(1) учтен в первых двух if'ах
            else if(lines1.get(1).equals(s2)){
                lines.add(new LineItem(Type.REMOVED, s1));
                lines1.remove(0);
            }
        }

       /*
        String s1, s2,s3;

        for (int i = 0; i < lines1.size ( ); i++)
            {  System.out.println(lines1);
                System.out.println(lines2);
                try
                    {
                        s1 = lines1.get (i);
                        s2 = lines2.get (0);
                        if (lines1.get (i).equals (lines2.get (0)))
                            {
                                lines.add (new LineItem (Type.___SAME, lines1.get (i)));
                                lines2.remove (0);

                            }
                        else
                            {s3=lines2.get (1);
                                if (lines1.get (i).equals (lines2.get (1)))
                                    {
                                        lines.add (new LineItem (Type.__ADDED, lines2.get (0)));
                                        lines2.remove (0);
                                    }
                                else
                                    {
                                        lines.add (new LineItem (Type.REMOVED, lines1.get (i)));

                                    }
                            }
                    }
                catch (Exception e)
                    {
                        if (lines1.size ( ) >= lines2.size ( ))
                            {
                                lines.add (new LineItem (Type.REMOVED, lines1.get (i)));
                            }
                        else
                            {
                                lines.add (new LineItem (Type.__ADDED, lines2.get (0)));
                            }
                    }

                System.out.println (lines.get (lines.size ( ) - 1).type + "                 " + lines.get (lines.size ( ) - 1).line);
            }
        */
        reader.close ( );
        readerF1.close ( );
        readerF2.close ( );
        for (LineItem li : lines)
            System.out.println (li.type + "                 " + li.line);
        }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type   type;
        public String line;

        public LineItem(Type type, String line)
            {
            this.type = type;
            this.line = line;
            }
    }
}
