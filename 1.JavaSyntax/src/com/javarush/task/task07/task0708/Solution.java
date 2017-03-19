package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Самая длинная строка
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
        int max = list.get(0).length();
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).length()) {
                index = i;
                max = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).length()) {
                System.out.println(list.get(i));
            }
        }

    }
}
