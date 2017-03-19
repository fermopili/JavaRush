package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int p=1;
        for(int i=1;i<11;i++)
            p*=i;
        System.out.println(p);
    }
}
