package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {

      //ArrayList<String> l=new ArrayList<String>(Arrays.asList("1","2"));
         ArrayList<String> l=new ArrayList();
         l.add("str1");
        l.add("str2");
        l.add("str2");
        l.add("str2");
        l.add("str2");
        System.out.println(l.size());
        for(int i=0;i<l.size();i++)
            System.out.println(l.get(i));
        //напишите тут ваш код
    }
}
