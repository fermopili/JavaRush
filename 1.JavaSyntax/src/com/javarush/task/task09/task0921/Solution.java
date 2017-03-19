package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> ar = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//напишите тут ваш код
        Integer val = null;
        while (true) {


            try {
                val = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                for (Integer i : ar) {
                    System.out.println(i);

                }
                break;
            }
            ar.add(val);

        }
    }
}
