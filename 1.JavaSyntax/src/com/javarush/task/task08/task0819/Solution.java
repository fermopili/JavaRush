package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {

    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> it = cats.iterator();
        Cat c = it.next();
        //напишите тут ваш код. step 3 - пункт 3
        cats.remove(c);
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cc = new HashSet<>();
        cc.add(new Cat());
        cc.add(new Cat());
        cc.add(new Cat());
        return cc;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4

        for (Cat c : cats) {
            System.out.println(c.toString());
        }

    }

    // step 1 - пункт 1
    public static class Cat {
    }
}
