package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/*
public class Solution
{

    public static void main(String[] args) throws IOException
        {
        // напишите тут ваш код
        BufferedReader     reader  = new BufferedReader(new InputStreamReader(System.in));
        String             name    = reader.readLine();
        ArrayList<Integer> ar      = new ArrayList<>();

        BufferedReader     readerF = new BufferedReader(new FileReader(name));
        while (true)
            {
                String str = readerF.readLine();
                if (str == null)
                    break;
                int value = Integer.parseInt(str);
                if (value % 2 == 0)
                    ar.add(value);

            }
        Collections.sort(ar);
        for (Integer d : ar)
            System.out.println(d);
        readerF.close();
        reader.close();

        }
}
*/
public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();
    BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
    try {
        TreeSet<Integer> set = new TreeSet<>();
        int num;
        String line;
        while ((line = file.readLine()) != null) {
            num = Integer.parseInt(line);
            if (num % 2 == 0) {
                set.add(num);
            }
        }
        for (int i : set) {
            System.out.println(i);
        }
        reader.close();
        file.close();
    } catch (IOException e) {
        System.out.println("Error: " + e);
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
            if (file != null) {
                file.close();
            }
        } catch (IOException e) {
        }
    }
    }
}