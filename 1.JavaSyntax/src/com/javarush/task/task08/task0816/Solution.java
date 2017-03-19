package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("QQQQQQQQ", new Date("may 1 1980"));
        map.put("Stallone3", new Date("JUNE 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("WWWWWWWWWWW", new Date("march 1 1980"));
        map.put("Stallone6", new Date("JUNE 1 1980"));
        map.put("Stallone7", new Date("JUNE 1 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("JUNE 1 1980"));
        map.put("Stallone0", new Date("JUNE 1 1980"));
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        boolean ret = true;
        while (ret) {
            ret = false;
            for (HashMap.Entry<String, Date> para : map.entrySet()) {
                Date value = para.getValue();
                if ((value.getMonth() >= 5) && (value.getMonth() <= 7)) {
                    map.remove(para.getKey());
                    ret = true;
                    break;
                }
            }

        }

    }


    public static void main(String[] args) {
        createMap();
    }




}
