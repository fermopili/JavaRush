package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {

        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if(c==' ')
                continue;
            if (isVowel(c)) {
                str1 = str1.concat(String.valueOf(c) );
                str1 = str1.concat(" ");
            } else {
                str2 = str2.concat(String.valueOf(c) );
                str2 = str2.concat(" ");
            }

        }
        System.out.println(str1);
        System.out.println(str2);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}