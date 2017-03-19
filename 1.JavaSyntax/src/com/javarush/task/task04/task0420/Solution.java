package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int[] m=new int[3];
        for (int i = 0; i < 3; i++)
            m[i] = sc.nextInt();
        int d=1;
        while(d!=0) {
            d = 0;
            for (int i = 0; i < 2; i++) {
                if (m[i] < m[i + 1]) {
                    int a = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = a;
                    d = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++)
            System.out.print(m[i]+" ");
    }
}
