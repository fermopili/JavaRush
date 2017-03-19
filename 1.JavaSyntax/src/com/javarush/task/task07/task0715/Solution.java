package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> l=new ArrayList<>();
        l.add("мама");
        l.add("мыла");
        l.add("раму");

        for(int i=0;i<l.size();i+=2)
            l.add(1+i,"именно");
        for(int i=0;i<l.size();i++)
            System.out.println(l.get(i));
    }
}
