package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());

//вывод содержимого коллекции на экран
        for (int i = 0; i < 13; i++) {
            String str = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0,str);
        }
        for (int i = 0; i < list.size(); i++)

            System.out.println(list.get(i));

    }
}
