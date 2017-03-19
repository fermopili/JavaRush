package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> l3 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        ArrayList<Integer> la = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
             list.add(Integer.parseInt(reader.readLine()));
        }
        for (Integer i : list) {
            if (i % 3 == 0)
                l3.add(i);
            if (i % 2 == 0)
                l2.add(i);
            if ((i % 3 != 0) && (i % 2 != 0))
                la.add(i);
        }
        printList(l3);
        printList(l2);
        printList(la);
    }
    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
}
