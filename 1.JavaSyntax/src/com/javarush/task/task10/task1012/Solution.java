package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
           // String s = "авгдеёжзийклмнопрстуфхцчшщъыьэюя";
            list.add(s.toLowerCase());
        }
        // напишите тут ваш код
        int[] count = new int[abcArray.length];

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (int j = 0; j < abcArray.length; j++) {
                    if (c == abcArray[j]) {
                        count[j]++;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + count[i]);
        }

        //
    }

}
