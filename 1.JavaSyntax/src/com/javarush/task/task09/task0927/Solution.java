package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> m = new HashMap<>();
        m.put("k1", new Cat("k1"));
        m.put("k2", new Cat("k2"));
        m.put("k3", new Cat("k3"));
        m.put("k4", new Cat("k4"));
        m.put("k5", new Cat("k5"));
        m.put("k6", new Cat("k6"));
        m.put("k7", new Cat("k7"));
        m.put("k8", new Cat("k8"));
        m.put("k9", new Cat("k9"));
        m.put("k0", new Cat("k0"));
        return m;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> s = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            Cat c=pair.getValue();
            s.add(c);
        }
        return s;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
