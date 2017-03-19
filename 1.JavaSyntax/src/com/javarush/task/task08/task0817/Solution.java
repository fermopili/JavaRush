package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Петров", "Петя");
        map.put("Иванов", "Ваня");
        map.put("Григорьев", "Гриша");
        map.put("Сидоров", "Сидор");
        map.put("Иванов1", "Петя");
        map.put("Николаев1", "Петя");
        map.put("Петров1", "Николай");
        map.put("Петров2", "Ваня");
        map.put("Иванов2", "Петя");
        map.put("Сидоров2", "Петя");
        return map;

    }
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pairC : copy.entrySet()) {
            String name = pairC.getValue();
            int count = 0;
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (pairC.getValue().equals(pair.getValue()))
                    count++;
            }
            if (count > 1) {
                removeItemFromMapByValue(map, name);
                copy = new HashMap<String, String>(map);
            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
