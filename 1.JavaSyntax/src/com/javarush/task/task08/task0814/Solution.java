package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> h = new HashSet<Integer>();
        h.add(10);
        h.add(9);
        h.add(110);
        h.add(120);
        h.add(130);
        h.add(140);
        h.add(1);
        h.add(160);
        h.add(7);
        h.add(180);
        h.add(190);
        h.add(100);
        h.add(101);
        h.add(102);
        h.add(103);
        h.add(4);
        h.add(105);
        h.add(106);
        h.add(107);
        h.add(8);
        return h;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator iterator = set.iterator();
        Integer ki;
        while (iterator.hasNext())      //проверка, есть ли ещё элементы
        {
            ki = (Integer) iterator.next();
            if (ki > 10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {
        createSet();
    }
}
