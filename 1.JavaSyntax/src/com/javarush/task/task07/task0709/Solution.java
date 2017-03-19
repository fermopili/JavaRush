package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
//ввод строк с клавиатуры
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }
//вывод содержимого коллекции на экран
        int min = list.get(0).length();

        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i).length()) {
                min = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i).length()) {
                System.out.println(list.get(i));
            }
        }
    }
}
