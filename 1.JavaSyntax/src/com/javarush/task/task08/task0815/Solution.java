package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int i = 0;
        for (HashMap.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();                  //значение
            if (name.equals(value))
                i++;
        }
        return i;
    }
    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
      if(  map.containsKey(lastName))
        return 1;
        return 0;
    }

    public static void main(String[] args) {
        createMap();

    }
}
