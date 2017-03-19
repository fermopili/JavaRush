package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> l=new ArrayList<>();
        int[] m1=new int[]{11,12,13,14,15};
        int[] m2=new int[]{21,22};
        int[] m3=new int[]{41,43,44,45};
        int[] m4=new int[]{1,2,3,4,5,6,7};
        int[] m5=new int[]{};
        l.add(m1);
        l.add(m2);
        l.add(m3);
        l.add(m4);
        l.add(m5);
        return l;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
