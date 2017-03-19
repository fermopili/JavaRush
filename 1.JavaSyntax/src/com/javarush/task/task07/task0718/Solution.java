package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            l.add(reader.readLine());
        int n = l.get(0).length();
        for (int i = 1; i < l.size(); i++) {
            if (n > l.get(i).length()) {
                System.out.print(i);
                return;
            }
            n = l.get(i).length();
        }
    }
}

