package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] l=new ArrayList[3];
        ArrayList<String> l1=new ArrayList();

        l1.add("0 1");
        l1.add("0 2");
        l1.add("0 3");
        l[0]=l1;
        l1=new ArrayList();
        l1.add("1 1");
        l1.add("1 2");
        l[1]=l1;
        l1=new ArrayList();
        l1.add("2 1");
        l1.add("2 2");
        l1.add("2 3");
        l[2]=l1;


        return l;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}