package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map=new  HashMap<String, String>();
        map.put("Петров", "Петя");
        map.put("Иванов", "Ваня");
        map.put("Григорьев", "Гриша");
        map.put("Сидоров", "Сидор");
        map.put("Иванов", "Петя");
        map.put("Николаев1", "Петя");
        map.put("Петров1", "Николай");
        map.put("Петров2", "Ваня");
        map.put("Иванов2", "Петя");
        map.put("Сидоров2", "Петя");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
