package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        double t2,t3,t4,t5;
        t2 = t - (int) (t / 5.) * 5;
           if (t2 <= 3)
            System.out.println("зелёный");
        else if ((t2 <= 4))
            System.out.println("желтый");
        else
            System.out.println("красный");
    }
}