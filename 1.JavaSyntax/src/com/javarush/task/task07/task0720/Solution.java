package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < N; i++)
            l.add(reader.readLine());
        for (int i = 0; i < M; i++) {
            String s = l.get(0);
            l.remove(0);
            l.add(s);
        }
        for (String s : l)
            System.out.println(s);
        //напишите тут ваш код
    }
}
