package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner((System.in));

      int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if( (a<(b+c)) &&
        (b<(a+c))&&
        (c<(b+a))
                )
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");

    }
}