package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


import org.w3c.dom.Document;

import javax.lang.model.util.Elements;
import java.io.*;
import java.util.*;


import org.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        String tag = args[0];
        tag = "span";
        String openTag="<"+tag;
        String closeTag="</"+tag;
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF  = reader.readLine ( );
        nameF = "c:/3";
        BufferedReader bufferedReader = new BufferedReader (new FileReader (nameF));
        String         s              = "";
        while (bufferedReader.ready ( ))
            {
                s = bufferedReader.readLine ( );
                s=s.substring (s.indexOf (openTag)); // обрезать ненужное спереди
                s = s.replaceAll("\\n|\\r", "");


                System.out.println (s);
            }
        reader.close ( );
        bufferedReader.close ( );
        }


}
*/
public class Solution
{
    public static void main(String[] args) throws Exception
        {
        //Читаем имя файла и сам файл в строку
        String tag = args[0];
       tag = "span";
        BufferedReader bf    = new BufferedReader (new InputStreamReader (System.in));
        String         nameF = bf.readLine ( );
       nameF = "c:/3";
        BufferedReader bufferedReader = new BufferedReader (new FileReader (nameF));
        String         fileContent    = "";
        String         s;
        while (bufferedReader.ready ( ))
            {
                s = bufferedReader.readLine ( );
                //  s=s.substring (s.indexOf (openTag)); // обрезать ненужное спереди
                //  s = s.replaceAll("\\n|\\r", "");
                fileContent = fileContent + s;

             //   System.out.println (s);
            }

        //проходимся по всем сабстрингам с фиксированным конечным индексом и возврастающимся начальным индексом на +1
        //если сабстринг находит тэг начала или закрытия, вносит в соответствующий список его индекс (начальный)
        ArrayList<Integer> openList  = new ArrayList<> ( );
        ArrayList<Integer> closeList = new ArrayList<> ( );
        String             sub       = fileContent;
        for (int i = 0; i < fileContent.length ( ); i++)
            {
                sub = fileContent.substring (i, fileContent.length ( ));
                if (!openList.contains (sub.indexOf ("<" + tag) + i) && sub.contains ("<" + tag))
                    {
                        openList.add (sub.indexOf ("<" + tag) + i);
                    }
                if (!closeList.contains (sub.indexOf ("</" + tag) + i) && sub.contains ("</" + tag))
                    {
                        closeList.add (sub.indexOf ("</" + tag) + i);
                    }
            }
        //Вносим все значения индексов начало тэгов в один список и сортируем
        //Нужно для понятия, какой индекс тэга начала соответствует индекс тэга закрытия
        ArrayList<Integer> sortList = new ArrayList<> (openList);
        sortList.addAll (closeList);
        Collections.sort (sortList);
        //редактируем список индексов тэгов начала приводя его к длине обьедененного списка
        //и заполняя пробелы (места индексов тэгов закрытия) 0-ями (маркируем эти индексы)
        ArrayList<Integer> openSortList = new ArrayList<> ( );
        openSortList.addAll (sortList);
        for (int i = 0; i < openSortList.size ( ); i++)
            {
                if (!openList.contains (openSortList.get (i)))
                    {
                        openSortList.set (i, 0);
                    }
            }
        //редактируем список индексов тэгов закрытия приводя его к длине обьедененного списка
        //и заполняя пробелы (места индексов тэгов открытия) 0-ями (маркируем эти индексы)
        ArrayList<Integer> closeSortList = new ArrayList<> ( );
        closeSortList.addAll (sortList);
        for (int i = 0; i < closeSortList.size ( ); i++)
            {
                if (!closeList.contains (closeSortList.get (i)))
                    {
                        closeSortList.set (i, 0);
                    }
            }
        //находим пары открытия-закрытия и вносим в мапу.
        //число 0-ей в списке индексов тэгов закрытия служат маркером того, сколько позиций отделяют тэг открытия
        //от его пары, тэга закрытия. Если же на месте индекса тэга открытия 0, то цикл продолжается, пока не будет не равен 0.
        int                       count = 0;
        HashMap<Integer, Integer> map   = new HashMap<> ( );
        outterLoop:
        for (int i = 0; i < openSortList.size ( ); i++)
            {
                for (int j = i; j < closeSortList.size ( ); j++)
                    {
                        if (closeSortList.get (j) == 0)
                            {
                                count++;
                            }
                        else if (openSortList.get (i) != 0)
                            {
                                map.put (openSortList.get (i), closeSortList.get (i + 1 + 2 * (count - 1)));
                                count = 0;
                                continue outterLoop;
                            }
                        else
                            {
                                continue outterLoop;
                            }
                    }
            }
        //выводим на экран сабстринг (так как индекс тэга закрытия его начальный индекс, находим его конечный индекс).
        for (Map.Entry<Integer, Integer> pair : map.entrySet ( ))
            {
                System.out.println (fileContent.substring (pair.getKey ( ), pair.getValue ( ) + tag.length ( ) + 3));
            }
        bf.close ( );
        bufferedReader.close ( );
        }
}