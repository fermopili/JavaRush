package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Set<String> set = new HashSet<String>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("жень-шень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        for (String s : set) {
            System.out.println(s);
        }
        Iterator iterator = set.iterator();

        while (iterator.hasNext())        //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            String text = (String)iterator.next();

            System.out.println(text);
        }
    }
}
