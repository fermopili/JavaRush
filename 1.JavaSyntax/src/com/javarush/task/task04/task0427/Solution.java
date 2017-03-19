package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        if (i >= 1 && i <= 999) {
            if ((i / 2) * 2 == i)
                System.out.print("четное ");
            else
                System.out.print("нечетное ");
            if (i >= 100 && i <= 999)
                System.out.println("трехзначное число");
            if (i >= 10 && i < 100)
                System.out.println("двузначное число");
            if (i >= 1 && i < 10)
                System.out.println("однозначное число");
        }
    }
}

