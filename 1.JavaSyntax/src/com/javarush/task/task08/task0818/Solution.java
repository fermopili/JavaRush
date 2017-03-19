package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Петров", 1000);
        map.put("Иванов", 200);
        map.put("Григорьев", 300);
        map.put("Сидоров", 700);
        map.put("Иванов1", 800);
        map.put("Николаев1", 900);
        map.put("Петров1", 10);
        map.put("Петров2", 200);
        map.put("Иванов2", 30000);
        map.put("Сидоров2", 700);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> mapC = new HashMap<>(map);
        for (HashMap.Entry<String, Integer> pair : mapC.entrySet()) {
            int value = pair.getValue();
            if (value < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {


    }


}