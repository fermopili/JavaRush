package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
        {
            labels.put(331., "1 565");
            labels.put(323., "2 565");
            labels.put(333., "3 565");
            labels.put(433., "4 565");
            labels.put(353., "5 565");
        }

    public static void main(String[] args)
        {
        System.out.println(labels);
        }
}
