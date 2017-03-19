package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        int max=list.get(0).length();
        int min=list.get(0).length();
        int indMax=0;
        int indMin=0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > max){
                max = list.get(i).length();
                indMax=i;
        }
            if (list.get(i).length() < min){
                min = list.get(i).length();
                indMin=i;
            }
        }
        if(indMin>indMax)
            System.out.println(list.get(indMax));
        else
            System.out.println(list.get(indMin));

    }
}
