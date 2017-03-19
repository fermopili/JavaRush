package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        ArrayList<String> l = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            l.add(0, reader.readLine());
        }

        for (int i = 0; i < l.size(); i++)
            System.out.println( l.get(i) );

    }
}
