package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String out = "";
        int pos = 0;
        while (pos != -1) {
            pos = s.indexOf(" ");
            if (pos != -1) {
                String    strA = s.substring(0, 1);
                strA=strA.toUpperCase();
                String    strB=s.substring(1, pos+1);
                out=out+strA+strB;
                s = s.substring(pos + 1);
            }
            else {
                String    strA = s.substring(0, 1);
                strA=strA.toUpperCase();
                String    strB=s.substring(1);
                out=out+strA+strB;
            }

        }
        System.out.println(out);
    }
}
