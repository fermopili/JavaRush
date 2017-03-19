package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> l = new ArrayList<String>();   //создание списка

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            l.add(reader.readLine());
        l.remove(2);


        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(l.size()-1-i));
        }




}
}


